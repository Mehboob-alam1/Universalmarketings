package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mehboob.universalmarketings.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
String userName,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());


        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etPasswordIn.getText().toString().isEmpty()){
                    binding.etPasswordIn.requestFocus();
                    binding.etPasswordIn.setError("Enter password");
                }
                if (binding.etUserNameIn.getText().toString().isEmpty()){
                    binding.etUserNameIn.requestFocus();
                    binding.etUserNameIn.setError("Enter user name");
                }
             Password=   binding.etPasswordIn.getText().toString();
              userName=  binding.etUserNameIn.getText().toString();
              Intent intent=new Intent(LoginActivity.this,DashBoardActivity.class);
              startActivity(intent);
            }
        });

        binding.txtSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
        binding.txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

}