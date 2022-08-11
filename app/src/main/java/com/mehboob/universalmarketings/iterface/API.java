package com.mehboob.universalmarketings.iterface;

import com.mehboob.universalmarketings.Constants;
import com.mehboob.universalmarketings.Models.Login;
import com.mehboob.universalmarketings.Models.LogoutResponse;
import com.mehboob.universalmarketings.Models.Messages;
import com.mehboob.universalmarketings.Models.MyWallet;
import com.mehboob.universalmarketings.Models.Profile;
import com.mehboob.universalmarketings.Models.Register;
import com.mehboob.universalmarketings.Models.WithdrawRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface API {

    @FormUrlEncoded
    @POST(Constants.LOGIN_URL)
    Call<Login> userInformation(@Field("username") String email, @Field("password") String password);

    @Headers({"Authorization: application/json"})
    @GET(Constants.PROFILE_URL)
    Call<Profile> getProfile(@Header("Authorization") String token);

    @Headers({"Authorization: application/json"})
    @GET(Constants.MY_WALLET)
    Call<List<MyWallet>> getMyWallet(@Header("Authorization") String token);

    @Headers({"Authorization: application/json"})
    @POST(Constants.LOGOUT)
    Call<LogoutResponse> logout(@Header("Authorization") String token);

    @Headers({"Authorization: application/json"})
    @FormUrlEncoded
    @POST(Constants.WITHDRAW_REQUEST)
    Call<WithdrawRequest> withdrawReq(@Field("amount") String amount,@Field("pin_code") String pin_code);


    @FormUrlEncoded
    @POST(Constants.REGISTER_URL)
    Call<Register> userRegistration(@Field("username") String username,
                                    @Field("contact_number") String contact_number,
                                    @Field("email") String email,
                                    @Field("security_pin") String security_pin,
                                    @Field("invitation_code") String invitation_code,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST(Constants.SMS_URL)
    Call<Messages> postMessages(@Field("address")
                                        String address,
                                @Field("body")
                                        String body);


}
