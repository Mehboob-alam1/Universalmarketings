package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {
ActivityAboutUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.aboutusBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.include3.toolbarBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(AboutUsActivity.this,ProfileActivity.class));
            }
        });
        binding.include3.toolbarBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutSection logoutSection=new LogoutSection();
                logoutSection.logout(AboutUsActivity.this);
            }
        });
    }
}
