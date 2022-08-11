package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class Messages {
    @SerializedName("address")
    String address;
    @SerializedName("body")
    String body;
    @SerializedName("success")
    String success;



    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Messages() {
    }

    public Messages(String address, String body) {
        this.address = address;
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
