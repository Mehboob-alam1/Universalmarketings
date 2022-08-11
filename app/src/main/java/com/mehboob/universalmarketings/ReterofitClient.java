package com.mehboob.universalmarketings;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehboob.universalmarketings.activities.MainActivity;

import org.jetbrains.annotations.Contract;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReterofitClient {
    public static Retrofit retrofit;
  public static SessionManager sessionManager;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            okHttpBuilder.addInterceptor(chain -> {

                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder().addHeader("Authorization", "");
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
