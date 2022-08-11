package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.databinding.ActivityTopUpBinding;

public class TopUpActivity extends AppCompatActivity {
ActivityTopUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTopUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.include9.toolbarBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TopUpActivity.this,ProfileActivity.class));            }
        });
        binding.include9.toolbarBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutSection logoutSection=new LogoutSection();
                logoutSection.logout(TopUpActivity.this);
            }
        });
        binding.topusBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.topupBtnRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openWhatsapp();

            }
        });
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
}