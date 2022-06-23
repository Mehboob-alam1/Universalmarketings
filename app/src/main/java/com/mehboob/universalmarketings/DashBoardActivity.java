package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.universalmarketings.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends AppCompatActivity  {
ActivityDashBoardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      binding.dashboardLogoutTxt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(DashBoardActivity.this,"Logout",Toast.LENGTH_SHORT).show();
          }
      });
      binding.dashboardProfileTxt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(DashBoardActivity.this,ProfileActivity.class));

          }
      });

    }


    public void topUp(View view) {
        Intent intent =new Intent(DashBoardActivity.this,TopUpActivity.class);
        startActivity(intent);
    }

    public void withDraw(View view) {
        Intent intent =new Intent(DashBoardActivity.this,WithDrawalActivity.class);
        startActivity(intent);
    }

    public void myWallet(View view) {
        Intent intent =new Intent(DashBoardActivity.this,MyWalletActivity.class);
        startActivity(intent);
    }

    public void invitation(View view) {
        Intent intent =new Intent(DashBoardActivity.this,InvitationActivity.class);
        startActivity(intent);
    }

    public void aboutUs(View view) {
        Intent intent =new Intent(DashBoardActivity.this,AboutUsActivity.class);
        startActivity(intent);
    }
}