package com.mehboob.universalmarketings;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mehboob.universalmarketings.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new Dialog(this);

        binding.profileSecurityCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        binding.profileContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        binding.profileEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        dialog.setContentView(R.layout.dialog_contactus);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView QR = dialog.findViewById(R.id.dialog_QR);
        Button btnRedirectWhatsapp = dialog.findViewById(R.id.dialog_btnRedirect);
        Button close = dialog.findViewById(R.id.dialog_btnClose);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnRedirectWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(sendIntent, ""));
                startActivity(sendIntent);
            }
        });
        dialog.show();
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