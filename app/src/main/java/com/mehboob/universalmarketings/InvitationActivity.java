package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.databinding.ActivityInvitationBinding;

public class InvitationActivity extends AppCompatActivity {
ActivityInvitationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInvitationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.invitaionBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
        binding.invitaionLevelTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InvitationActivity.this, "Invitation Level", Toast.LENGTH_SHORT).show();
            }
        });
        binding.invitaionLogoutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InvitationActivity.this, "Invitation Logout", Toast.LENGTH_SHORT).show();
            }
        });
        binding.invitaionPofileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InvitationActivity.this,ProfileActivity.class));            }
        });
    }
}