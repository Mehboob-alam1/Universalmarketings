package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.databinding.ActivityWithDrawalBinding;

public class WithDrawalActivity extends AppCompatActivity {
    ActivityWithDrawalBinding binding;
    String cashPointBalance;
    private String pinCode, withdrawAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWithDrawalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.withdrawHistoryTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WithDrawalActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
        binding.withdrawlProfileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WithDrawalActivity.this,ProfileActivity.class));            }
        });
        binding.withdrawlLogoutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WithDrawalActivity.this, "With drawal logout clicked", Toast.LENGTH_SHORT).show();
            }
        });
        binding.withdrawBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cashPointBalance = binding.withdrawlCashTxt.getText().toString();

        binding.withdrawWithDrawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.withdrawAmountEt.getText().toString().isEmpty()) {
                    binding.withdrawAmountEt.setError("Enter your amount");
                } else if (binding.withdrawPinCodeEt.getText().toString().isEmpty()) {
                    binding.withdrawPinCodeEt.setError("Enter your pin code");
                } else {
                    withdrawAmount = binding.withdrawAmountEt.getText().toString();
                    pinCode = binding.withdrawPinCodeEt.getText().toString();
                }
            }
        });
    }
}