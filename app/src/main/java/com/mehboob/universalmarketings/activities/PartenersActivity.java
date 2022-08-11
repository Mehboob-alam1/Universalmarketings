package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.databinding.ActivityPartenersBinding;

public class PartenersActivity extends AppCompatActivity {
ActivityPartenersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPartenersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.include.toolbarBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutSection logoutSection =new LogoutSection();
                logoutSection.logout(PartenersActivity.this);
            }
        });
        binding.include.toolbarBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PartenersActivity.this,ProfileActivity.class));
            }
        });
        binding.partenerBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }


        });
    }
}