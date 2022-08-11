package com.mehboob.universalmarketings;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.SessionManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;

public class ReterofitPlaceHolder {



    public static Retrofit retrofit;
    public static SessionManager sessionManager;

    public static Retrofit getRetrofitInstance(Context context) {

        if (retrofit == null) {
         sessionManager=new SessionManager(context);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            okHttpBuilder.addInterceptor(chain -> {

                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder()
                        .addHeader("Authorization","application/json")
                        .addHeader("Authorization", "Bearer "+sessionManager.fetchAuthToken());

                return chain.proceed(requestBuilder.build());
            });
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpBuilder.build())
                    .build();
        }
        return retrofit;
    }
}
