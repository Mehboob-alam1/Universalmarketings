package com.mehboob.universalmarketings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mehboob.universalmarketings.Models.LogoutResponse;
import com.mehboob.universalmarketings.activities.LoginActivity;
import com.mehboob.universalmarketings.iterface.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutSection {
SessionManager sessionManager;
String success;
ProgressDialog dialog;
        public void logout(Context context) {
            dialog=new ProgressDialog(context);
            dialog.setTitle("Logout");
            dialog.setMessage("Please Wait....");
            dialog.show();
sessionManager=new SessionManager(context);

                API api = ReterofitPlaceHolder.getRetrofitInstance(context).create(API.class);

          Call<LogoutResponse> call= api.logout(sessionManager.fetchAuthToken());

          call.enqueue(new Callback<LogoutResponse>() {
                  @Override
                  public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                          if (response.isSuccessful()){
                              LogoutResponse data=    response.body();
                              Toast.makeText(context, ""+data.getSuccess(), Toast.LENGTH_SHORT).show();
                              dialog.dismiss();
                                 startLogin(context);
                              success= data.getSuccess();

                          }else{
                              dialog.dismiss();
                                  Toast.makeText(context, "Something went wrong... Try Again", Toast.LENGTH_SHORT).show();
                          }
                  }

                  @Override
                  public void onFailure(Call<LogoutResponse> call, Throwable t) {
                      dialog.dismiss();
                          Toast.makeText(context, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                  }
          });
        }

    private void startLogin(Context context) {

        Intent intent=new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
