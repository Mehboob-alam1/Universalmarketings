package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class MyWallet {
    @SerializedName("id")
    String id;
   @SerializedName("member_id")
    String member_id;
    @SerializedName("cash_points")
    String cash_points;
    @SerializedName("total_profit")
    String total_profit;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("updated_at")
    String updated_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCash_points() {
        return cash_points;
    }

    public void setCash_points(String cash_points) {
        this.cash_points = cash_points;
    }

    public String getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(String total_profit) {
        this.total_profit = total_profit;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
