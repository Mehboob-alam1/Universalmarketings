package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.databinding.ActivityMyWalletBinding;

public class MyWalletActivity extends AppCompatActivity {
ActivityMyWalletBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyWalletBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.myWalletBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.myWalletProfileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyWalletActivity.this,ProfileActivity.class));

            }
        });
        binding.myWalletLogoutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyWalletActivity.this, "My Wallet Logout", Toast.LENGTH_SHORT).show();
            }
        });


        binding.myWalletTopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyWalletActivity.this,TopUpActivity.class));
            }
        });
        binding.myWalletWithdrawalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyWalletActivity.this,WithDrawalActivity.class));
            }
        });
    }
}