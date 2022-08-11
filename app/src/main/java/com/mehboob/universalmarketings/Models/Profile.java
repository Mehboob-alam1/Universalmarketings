package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("username")
   private String username;
    @SerializedName("email")
   private String email;
    @SerializedName("contact")
   private String contact;
    @SerializedName("invitation_code")
   private String invitation_code;
    @SerializedName("invitation_by")
   private String invitation_by;
    @SerializedName("level")
   private String level;
    @SerializedName("account_name")
   private String account_name;
    @SerializedName("bank_name")
   private String bank_name;



    public Profile(String username, String email, String contact, String invitation_code, String invitation_by, String level, String account_name, String bank_name) {
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.invitation_code = invitation_code;
        this.invitation_by = invitation_by;
        this.level = level;
        this.account_name = account_name;
        this.bank_name = bank_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public String getInvitation_by() {
        return invitation_by;
    }

    public void setInvitation_by(String invitation_by) {
        this.invitation_by = invitation_by;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
