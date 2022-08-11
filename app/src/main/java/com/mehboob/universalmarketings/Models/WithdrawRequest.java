package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class WithdrawRequest {

    @SerializedName("amount")
    String amount;
    @SerializedName("pin_code")
    String pin_code;
    @SerializedName("success")
    String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public WithdrawRequest() {
    }

    public WithdrawRequest(String amount, String pin_code) {
        this.amount = amount;
        this.pin_code = pin_code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }
}
