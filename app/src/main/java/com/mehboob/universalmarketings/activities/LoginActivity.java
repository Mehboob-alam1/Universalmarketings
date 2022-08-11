package com.mehboob.universalmarketings.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.Models.Login;
import com.mehboob.universalmarketings.Models.Messages;
import com.mehboob.universalmarketings.ReterofitClient;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivityLoginBinding;
import com.mehboob.universalmarketings.iterface.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    String userName, Password;

    SessionManager sessionManager;
    ProgressDialog dialog;




    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog=new ProgressDialog(LoginActivity.this);
        dialog.setTitle("Login");
        dialog.setMessage("Please wait....");
        dialog.setCancelable(false);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(LoginActivity.this);



        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (binding.etPasswordIn.getText().toString().isEmpty()) {
                    binding.etPasswordIn.requestFocus();
                    binding.etPasswordIn.setError("Enter password");
                } else if (binding.etUserNameIn.getText().toString().isEmpty()) {
                    binding.etUserNameIn.requestFocus();
                    binding.etUserNameIn.setError("Enter user name");
                } else {
                    dialog.show();
                    Password = binding.etPasswordIn.getText().toString();
                    userName = binding.etUserNameIn.getText().toString();

                    //


                    API api = ReterofitClient.getRetrofitInstance().create(API.class);
                    Call<Login> call = api.userInformation(userName, Password);
                    call.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {
                            if (response.isSuccessful()) {
                                dialog.dismiss();
                                Log.e("TAG", "success");
                                Login obj = response.body();
                                assert obj != null;
                                sessionManager.saveAuthToken(obj.getToken());

                                startActivity(new Intent(LoginActivity.this, PaymentActivity.class));
                            } else {
                                dialog.dismiss();
                                Log.e("TAG", "Failed");
                                Toast.makeText(LoginActivity.this, "Something went wrong try again", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Log.e("TAG", "response" + t.getLocalizedMessage());
                            dialog.dismiss();
                            Toast.makeText(LoginActivity.this, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });

        binding.txtSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }


}