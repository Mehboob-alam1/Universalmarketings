package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("username")
    String username;

    public RegisterResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
