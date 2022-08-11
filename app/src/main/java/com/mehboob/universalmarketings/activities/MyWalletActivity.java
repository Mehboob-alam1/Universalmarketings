package com.mehboob.universalmarketings.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.LogoutSection;
import com.mehboob.universalmarketings.Models.MyWallet;

import com.mehboob.universalmarketings.ReterofitPlaceHolder;
import com.mehboob.universalmarketings.SessionManager;
import com.mehboob.universalmarketings.databinding.ActivityMyWalletBinding;
import com.mehboob.universalmarketings.iterface.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyWalletActivity extends AppCompatActivity {
ActivityMyWalletBinding binding;
SessionManager sessionManager;
String id,cashPoints,createdAt,memberId,totalProfit,updatedAt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyWalletBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager=new SessionManager(this);

        fetchMyWallet();


        binding.myWalletBackBtn.setOnClickListener(view -> onBackPressed());
        binding.include7.toolbarBtnProfile.setOnClickListener(view -> startActivity(new Intent(MyWalletActivity.this,ProfileActivity.class)));
        binding.include7.toolbarBtnLogout.setOnClickListener(view -> {
            LogoutSection logoutSection =new LogoutSection();
            logoutSection.logout(MyWalletActivity.this);
        });


        binding.myWalletTopupBtn.setOnClickListener(view -> startActivity(new Intent(MyWalletActivity.this,TopUpActivity.class)));
        binding.myWalletWithdrawalBtn.setOnClickListener(view -> startActivity(new Intent(MyWalletActivity.this,WithDrawalActivity.class)));
    }

    private void fetchMyWallet() {
        API api = ReterofitPlaceHolder.getRetrofitInstance(MyWalletActivity.this).create(API.class);

        Call<List<MyWallet>>    call = api.getMyWallet(sessionManager.fetchAuthToken());
        call.enqueue(new Callback<List<MyWallet>>() {
            @Override
            public void onResponse(@NonNull Call<List<MyWallet>> call, @NonNull Response<List<MyWallet>> response) {
                if (response.isSuccessful()){

                    try {
                       List<MyWallet>  obj=    response.body();
                        assert obj != null;
                        for (MyWallet post : obj) {


                                id=   post.getId();
                                cashPoints=post.getCash_points();
                                createdAt=post.getCreated_at();
                                memberId=post.getMember_id();
                                totalProfit=post.getTotal_profit();
                                updatedAt=post.getUpdated_at();

                            Constants.CashPoints=cashPoints;
                        }

                           binding.myWalletCashPointsTxt.setText(cashPoints);
                           binding.myWalletTotalProfitTxt.setText(totalProfit);


                    }catch (Exception e){
                        Toast.makeText(MyWalletActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MyWalletActivity.this, "Something went wrong.... Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MyWallet>> call, @NonNull Throwable t) {
                Toast.makeText(MyWalletActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}