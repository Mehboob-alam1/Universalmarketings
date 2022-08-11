package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mehboob.universalmarketings.databinding.ActivityRulesBinding;

public class RulesActivity extends AppCompatActivity {
ActivityRulesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRulesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rulesBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}