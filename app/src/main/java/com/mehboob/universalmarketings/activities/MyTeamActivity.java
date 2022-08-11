package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.databinding.ActivityMyTeamBinding;

public class MyTeamActivity extends AppCompatActivity {
ActivityMyTeamBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyTeamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.include6.toolbarBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyTeamActivity.this,ProfileActivity.class));
            }
        });
        binding.include6.toolbarBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutSection logoutSection=new LogoutSection();
                logoutSection.logout(MyTeamActivity.this);
            }
        });

        binding.myTeamBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}