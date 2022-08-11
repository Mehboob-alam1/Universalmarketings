package com.mehboob.universalmarketings.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


import com.mehboob.universalmarketings.LogoutSection;

import com.mehboob.universalmarketings.R;

import com.mehboob.universalmarketings.SessionManager;

import com.mehboob.universalmarketings.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends AppCompatActivity {
    ActivityDashBoardBinding binding;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(this);


        binding.include2.toolbarBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutSection logoutSection = new LogoutSection();
                logoutSection.logout(DashBoardActivity.this);
            }
        });
        binding.include2.toolbarBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoardActivity.this, ProfileActivity.class));

            }
        });

    }


    public void topUp(View view) {
        Intent intent = new Intent(DashBoardActivity.this, TopUpActivity.class);
        startActivity(intent);
    }

    public void withDraw(View view) {
        Intent intent = new Intent(DashBoardActivity.this, WithDrawalActivity.class);
        startActivity(intent);
    }

    public void myWallet(View view) {
        Intent intent = new Intent(DashBoardActivity.this, MyWalletActivity.class);
        startActivity(intent);
    }

    public void invitation(View view) {
        Intent intent = new Intent(DashBoardActivity.this, InvitationActivity.class);
        startActivity(intent);
    }

    public void aboutUs(View view) {
        Intent intent = new Intent(DashBoardActivity.this, AboutUsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        customExitDialog();
    }

    public void customExitDialog() {
        // creating custom dialog
        final Dialog dialog = new Dialog(DashBoardActivity.this);

        // setting content view to dialog
        dialog.setContentView(R.layout.alertdialog_exit);

        // getting reference of TextView
        TextView dialogButtonYes = (TextView) dialog.findViewById(R.id.textViewYes);
        TextView dialogButtonNo = (TextView) dialog.findViewById(R.id.textViewNo);

        // click listener for No
        dialogButtonNo.setOnClickListener(v -> {
            // dismiss the dialog
            dialog.dismiss();

        });
        // click listener for Yes
        dialogButtonYes.setOnClickListener(v -> {
            // dismiss the dialog and exit the exit
            dialog.dismiss();
            finish();

        });

        // show the exit dialog
        dialog.show();
    }

}