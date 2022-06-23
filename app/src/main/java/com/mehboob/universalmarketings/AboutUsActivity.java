package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        binding.aboutUsLevelTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutUsActivity.this, "About us level", Toast.LENGTH_SHORT).show();
            }
        });
        binding.aboutUsProfileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(AboutUsActivity.this,ProfileActivity.class));
            }
        });
        binding.aboutUsLogoutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutUsActivity.this, "About us Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
