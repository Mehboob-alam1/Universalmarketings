package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivityInvitationBinding;

public class InvitationActivity extends AppCompatActivity {
    ActivityInvitationBinding binding;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(InvitationActivity.this);
        String invitationCode = sessionManager.fetchInvitationCode();
        binding.invitationInvitationCode.setText(invitationCode);
        binding.invitaionBackBtn.setOnClickListener(view -> onBackPressed());

        binding.include5.toolbarBtnLogout.setOnClickListener(view -> {
            LogoutSection logoutSection = new LogoutSection();
            logoutSection.logout(InvitationActivity.this);
        });
        binding.include5.toolbarBtnProfile.setOnClickListener(view -> startActivity(new Intent(InvitationActivity.this, ProfileActivity.class)));
    }
}