package com.mehboob.universalmarketings.activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.Models.Profile;
import com.mehboob.universalmarketings.ReterofitPlaceHolder;
import com.mehboob.universalmarketings.R;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivityProfileBinding;
import com.mehboob.universalmarketings.iterface.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    Dialog dialog;
    SessionManager sessionManager;
    String level, userName, bankName, accountName, contact, email, invitationBy, invitationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new Dialog(this);
        sessionManager = new SessionManager(this);
        fetchProfile();

        binding.include8.toolbarBtnProfile.setOnClickListener(view -> Toast.makeText(ProfileActivity.this, "You are already on profile section", Toast.LENGTH_SHORT).show());
        binding.include8.toolbarBtnLogout.setOnClickListener(view -> {
            LogoutSection logoutSection = new LogoutSection();
            logoutSection.logout(ProfileActivity.this);
        });
        binding.profileSecurityCentre.setOnClickListener(view -> openDialog());
        binding.profileContactUs.setOnClickListener(view -> openDialog());
        binding.profileEditProfile.setOnClickListener(view -> openDialog());
    }

    private void fetchProfile() {
        API api = ReterofitPlaceHolder.getRetrofitInstance(ProfileActivity.this).create(API.class);
        Call<Profile> call = api.getProfile(sessionManager.fetchAuthToken());
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(@NonNull Call<Profile> call, @NonNull Response<Profile> response) {
                if (response.isSuccessful()) {
                    try {
                        Profile obj = response.body();

                        assert obj != null;
                        level = obj.getLevel();
                        userName = obj.getUsername();
                        bankName = obj.getBank_name();
                        accountName = obj.getAccount_name();
                        contact = obj.getContact();
                        email = obj.getEmail();
                        Constants.ACCOUNT_NAME=accountName;
                        Constants.BANK_NAME=bankName;
                        invitationBy = obj.getInvitation_by();
                        invitationCode = obj.getInvitation_code();

                        binding.profileLevelTxt1.setText(level);
                        binding.profileUserNameTxt.setText(userName);
                        binding.profileUserNameTxtU.setText(userName);
                        binding.profileEmailTxt.setText(email);
                        binding.profileEmailTxtU.setText(email);
                        binding.profileContactTxt.setText(contact);
                        binding.profileContactTxtU.setText(contact);
                        binding.profileInvitationCode.setText(invitationCode);
                        sessionManager.saveInvitationCode(invitationCode);
                    } catch (Exception e) {
                        Log.e("TAG ", "Error " + e.getMessage());

                    }

                } else {
                    Toast.makeText(ProfileActivity.this, "No response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Profile> call, @NonNull Throwable t) {
                Log.e("TAG", "Profile" + t.getLocalizedMessage());
                Toast.makeText(ProfileActivity.this, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void openDialog() {
        dialog.setContentView(R.layout.dialog_contactus);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnRedirectWhatsapp = dialog.findViewById(R.id.dialog_btnRedirect);
        Button close = dialog.findViewById(R.id.dialog_btnClose);

        close.setOnClickListener(view -> dialog.dismiss());
        btnRedirectWhatsapp.setOnClickListener(view -> {
         openWhatsapp();
        });
        dialog.show();
    }


    private void openWhatsapp() {
        try {
            String text = "This is a test";// Replace with your message.

            String toNumber = "60 11-3665 6257"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public void profileNotifaction(View view) {

        startActivity(new Intent(ProfileActivity.this, NotificationActivity.class));
    }

    public void profileWallet(View view) {
        startActivity(new Intent(ProfileActivity.this, MyWalletActivity.class));
    }

    public void profileMyTeam(View view) {
        startActivity(new Intent(ProfileActivity.this, MyTeamActivity.class));
    }

    public void profileInvitaion(View view) {
        startActivity(new Intent(ProfileActivity.this, InvitationActivity.class));
    }

    public void profileFAQ(View view) {
        startActivity(new Intent(ProfileActivity.this, FAQActivity.class));
    }

    public void profilePartners(View view) {
        startActivity(new Intent(ProfileActivity.this, PartenersActivity.class));
    }

    public void profileRules(View view) {
        startActivity(new Intent(ProfileActivity.this, RulesActivity.class));
    }

    public void profileAboutUs(View view) {
        startActivity(new Intent(ProfileActivity.this, AboutUsActivity.class));
    }
}