package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mehboob.universalmarketings.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    String userName, Email, Password, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.etEmail.getText().toString().isEmpty()) {
                    binding.etEmail.requestFocus();
                    binding.etEmail.setError("Email required");
                }
                if (binding.etUserName.getText().toString().isEmpty()) {
                    binding.etUserName.requestFocus();
                    binding.etUserName.setError("Enter User Name");
                }
                if (binding.etPassword.getText().toString().isEmpty()) {
                    binding.etPassword.requestFocus();
                    binding.etPassword.setError("Enter Password");
                }
                if (binding.etConfPass.getText().toString().isEmpty()) {
                    binding.etConfPass.requestFocus();
                    binding.etConfPass.setError("Enter Confirm password");
                }
                userName = binding.etUserName.getText().toString();
                Email = binding.etEmail.getText().toString();
                Password = binding.etPassword.getText().toString();
                confirmPass = binding.etConfPass.getText().toString();

            }
        });

        binding.txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}