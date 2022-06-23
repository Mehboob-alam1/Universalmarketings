package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mehboob.universalmarketings.databinding.ActivityPartenersBinding;

public class PartenersActivity extends AppCompatActivity {
ActivityPartenersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPartenersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.partenerBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}