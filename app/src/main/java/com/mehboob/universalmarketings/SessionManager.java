package com.mehboob.universalmarketings;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.sql.Statement;

public class SessionManager {

    private static final String USER_TOKEN = "user_token";
    private static final String USER_REG = "Redirected";
    private static final String SMS = "SMS";
    private static final String INVITATION_CODE = "invitCode";
    SharedPreferences sharedPreferences;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("Token", MODE_PRIVATE);
        sharedPreferences = context.getSharedPreferences("Redirected", MODE_PRIVATE);
        sharedPreferences = context.getSharedPreferences("SMS", MODE_PRIVATE);

    }

    public void saveInvitationCode(String invitationCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(INVITATION_CODE, invitationCode);
        editor.apply();

    }

    public String fetchInvitationCode() {
        return sharedPreferences.getString(INVITATION_CODE, null);
    }

    public void saveSMS(String sms) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SMS, sms);
        editor.apply();
    }

    public String fetchSMS() {
        return sharedPreferences.getString(SMS, null);
    }

    public void saveRedirected(String redirected) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_REG, redirected);
        editor.apply();
    }

    public String fetchRedirected() {
        return sharedPreferences.getString(USER_REG, null);
    }

    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    public String fetchAuthToken() {

        return sharedPreferences.getString(USER_TOKEN, null);
    }


}
