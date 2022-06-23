package com.mehboob.universalmarketings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String permission = Manifest.permission.READ_SMS;
    private int requestCode = 1;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.lst);
        int REQUEST_PHONE_CALL = 1;

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, REQUEST_PHONE_CALL);
        }
        // Create Inbox box URI
        Uri inboxURI = Uri.parse("content://sms/inbox");

// List required columns
        String[] reqCols = new String[]{"_id", "address", "body"};

// Get Content Resolver object, which will deal with Content Provider
        ContentResolver cr = getContentResolver();

// Fetch Inbox SMS Message from Built-in Content Provider
        Cursor c = cr.query(inboxURI, reqCols, null, null, null);

// Attached Cursor with adapter and display in listview
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, c,
                new String[]{"address", "body"}, new int[]{
                R.id.txt_no, R.id.txt_msg});
        lst.setAdapter(adapter);
    }
}