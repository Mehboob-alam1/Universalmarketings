package com.mehboob.universalmarketings.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mehboob.universalmarketings.Models.Messages;
import com.mehboob.universalmarketings.R;
import com.mehboob.universalmarketings.ReterofitClient;
import com.mehboob.universalmarketings.SMSRecevier;
import com.mehboob.universalmarketings.iterface.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnGetStarted;




    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        btnGetStarted = findViewById(R.id.splashGetStartedBtn);
        btnGetStarted.setVisibility(View.INVISIBLE);
        Dexter.withContext(MainActivity.this)
                .withPermission(Manifest.permission.RECEIVE_SMS)

                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {/*
                     ... */

                        btnGetStarted.setVisibility(View.VISIBLE);
                        btnGetStarted.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                startActivity(new Intent(MainActivity.this, NewDashBoardActivity.class));

                            }
                        });
                        //

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                        PermissionListener dialogPermissionListener =
                                DialogOnDeniedPermissionListener.Builder
                                        .withContext(MainActivity.this)
                                        .withTitle("Message Permission")
                                        .withMessage("Message permission is needed to take pictures of your cat")
                                        .withButtonText(android.R.string.ok)
                                        .withIcon(R.mipmap.ic_launcher)
                                        .build();


                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* .

                    .. */
                    }
                }).onSameThread().check();


    }

}
