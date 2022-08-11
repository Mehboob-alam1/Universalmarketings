package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mehboob.universalmarketings.Models.Register;
import com.mehboob.universalmarketings.Models.RegisterResponse;
import com.mehboob.universalmarketings.ReterofitClient;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivitySignUpBinding;
import com.mehboob.universalmarketings.iterface.API;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    String userName, Contactno, Email, Securitypin, Invitationcode, Password;
    SessionManager sessionManager;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        dialog=new ProgressDialog(this);
        dialog.setTitle("Register");
        dialog.setMessage("Please Wait while we register you..");

        sessionManager = new SessionManager(this);
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (binding.etEmail.getText().toString().isEmpty()) {
                    binding.etEmail.requestFocus();
                    binding.etEmail.setError("Email required");
                }
                if (binding.etContactNo.getText().toString().isEmpty()) {
                    binding.etContactNo.requestFocus();
                    binding.etContactNo.setError("Enter contact number");
                }
                if (binding.etEmail.getText().toString().isEmpty()) {
                    binding.etEmail.requestFocus();
                    binding.etEmail.setError("Enter email");
                }
                if (binding.etSecurityPin.getText().toString().isEmpty()) {
                    binding.etSecurityPin.requestFocus();
                    binding.etSecurityPin.setError("Enter security pin");
                }
                if (binding.etInvitaionCode.getText().toString().isEmpty()) {
                    binding.etInvitaionCode.requestFocus();
                    binding.etInvitaionCode.setError("Enter invitation code");
                }
                if (binding.etPassword.getText().toString().isEmpty()) {
                    binding.etPassword.requestFocus();
                    binding.etPassword.setError("Enter password");
                }
                dialog.show();

                userName = binding.etUserName.getText().toString();
                Contactno = binding.etContactNo.getText().toString();
                Email = binding.etEmail.getText().toString();
                Securitypin = binding.etSecurityPin.getText().toString();
                Invitationcode = binding.etInvitaionCode.getText().toString();
                Password = binding.etPassword.getText().toString();


                registerUser();


            }
        });

        binding.txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }

    private void registerUser() {
        API api = ReterofitClient.getRetrofitInstance().create(API.class);
        Call<Register> call = api.userRegistration(userName, Contactno, Email, Securitypin, Invitationcode, Password);

        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.isSuccessful()) {
                    Register obj = response.body();
                    assert obj != null;
                    Log.e("TAG", "REGISTER " + obj.getReturn_redirect());
                    sessionManager.saveRedirected(obj.getReturn_redirect());
                 String redirected=   sessionManager.fetchRedirected();
                    if (Objects.equals(redirected, "dashboard")){
                        dialog.dismiss();

                        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                    }


                    sessionManager.saveRedirected(obj.getReturn_redirect());

                } else {
                    Log.e("TAG", "REGISTER Failed");
                    dialog.dismiss();
                    Toast.makeText(SignUpActivity.this, "Try Again Using Different user name", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Log.e("TAG", "REGISTER " + t.getLocalizedMessage());
                dialog.dismiss();
                Toast.makeText(SignUpActivity.this, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}