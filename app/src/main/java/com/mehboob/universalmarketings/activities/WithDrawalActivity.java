package com.mehboob.universalmarketings.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.Models.WithdrawRequest;
import com.mehboob.universalmarketings.ReterofitPlaceHolder;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivityWithDrawalBinding;
import com.mehboob.universalmarketings.iterface.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WithDrawalActivity extends AppCompatActivity {
    ActivityWithDrawalBinding binding;
    String cashPointBalance;
    SessionManager sessionManager;
    private String pinCode, withdrawAmount;
    WithdrawRequest obj;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWithDrawalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(this);
        dialog = new ProgressDialog(WithDrawalActivity.this);
        dialog.setTitle("Withdraw");
        dialog.setMessage("Please wait.....");
        dialog.setCancelable(false);
        binding.withdrawAccountName.setText(Constants.ACCOUNT_NAME);
        binding.withdrawBankName.setText(Constants.BANK_NAME);
        binding.withdrawlCashTxt.setText(Constants.CashPoints);
        binding.include0.toolbarBtnProfile.setOnClickListener(view -> startActivity(new Intent(WithDrawalActivity.this, ProfileActivity.class)));
        binding.include0.toolbarBtnLogout.setOnClickListener(view -> {
            LogoutSection logoutSection = new LogoutSection();
            logoutSection.logout(WithDrawalActivity.this);
        });
        binding.withdrawBackBtn.setOnClickListener(view -> onBackPressed());

        cashPointBalance = binding.withdrawlCashTxt.getText().toString();

        binding.withdrawWithDrawBtn.setOnClickListener(view -> {
            if (binding.withdrawAmountEt.getText().toString().isEmpty()) {
                binding.withdrawAmountEt.setError("Enter your amount");
            } else if (binding.withdrawPinCodeEt.getText().toString().isEmpty()) {
                binding.withdrawPinCodeEt.setError("Enter your pin code");
            } else {
                dialog.show();
                withdrawAmount = binding.withdrawAmountEt.getText().toString();
                pinCode = binding.withdrawPinCodeEt.getText().toString();

                API api = ReterofitPlaceHolder.getRetrofitInstance(WithDrawalActivity.this).create(API.class);

                Call<WithdrawRequest> call = api.withdrawReq(withdrawAmount, pinCode);

                call.enqueue(new Callback<WithdrawRequest>() {
                    @Override
                    public void onResponse(@NonNull Call<WithdrawRequest> call, @NonNull Response<WithdrawRequest> response) {
                        if (response.isSuccessful()) {
                            dialog.dismiss();
                            obj = response.body();
                            binding.withdrawAmountEt.setText("");
                            binding.withdrawPinCodeEt.setText("");

                            assert obj != null;
                            Toast.makeText(WithDrawalActivity.this, "" + obj.getSuccess(), Toast.LENGTH_SHORT).show();
                        } else {
                            dialog.dismiss();
                            binding.withdrawAmountEt.setText("");
                            binding.withdrawPinCodeEt.setText("");

                            Toast.makeText(WithDrawalActivity.this, "Check pin code and try again.. You might have insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<WithdrawRequest> call, @NonNull Throwable t) {
                        dialog.dismiss();
                        binding.withdrawAmountEt.setText("");
                        binding.withdrawPinCodeEt.setText("");
                        Toast.makeText(WithDrawalActivity.this, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}