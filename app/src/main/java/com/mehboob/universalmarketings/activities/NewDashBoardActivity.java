package com.mehboob.universalmarketings.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mehboob.universalmarketings.Models.RecyclerDashboardModel;
import com.mehboob.universalmarketings.R;
import com.mehboob.universalmarketings.adapters.RecyclerDashboardAdapter;
import com.mehboob.universalmarketings.databinding.ActivityNewDashBoardBinding;

import java.util.ArrayList;

public class NewDashBoardActivity extends AppCompatActivity {
    ActivityNewDashBoardBinding binding;
    ArrayList<RecyclerDashboardModel> list;
    RecyclerDashboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        binding = ActivityNewDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add(new RecyclerDashboardModel(R.drawable.mybt, "My BT"));
        list.add(new RecyclerDashboardModel(R.drawable.upgradebroadband, "Upgrade broadband"));
        list.add(new RecyclerDashboardModel(R.drawable.tv, "TV"));
        list.add(new RecyclerDashboardModel(R.drawable.sport, "Sport"));
        list.add(new RecyclerDashboardModel(R.drawable.mobile, "Mobile"));

        adapter = new RecyclerDashboardAdapter(this, list);
        binding.recyclerdashBoard.setAdapter(adapter);
        binding.btnBeOneOfUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewDashBoardActivity.this, LoginActivity.class));
            }
        });
        binding.recyclerdashBoard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        binding.notBTCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewDashBoardActivity.this, LoginActivity.class));
            }
        });


    }
}