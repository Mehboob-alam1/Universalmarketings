package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    @SerializedName("Success")
    String Success;

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }
}
