package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("username")
    String username;
    @SerializedName("contact_number")
    String contact_number;
    @SerializedName("email")
    String email;
    @SerializedName("security_pin")
    String security_pin;
    @SerializedName("invitation_code")
    String invitation_code;
    @SerializedName("password")
    String password;
    @SerializedName("return redirect")
    String return_redirect;


    public Register() {
    }

    public Register(String username, String contact_number, String email, String security_pin, String invitation_code, String password, String return_redirect) {
        this.username = username;
        this.contact_number = contact_number;
        this.email = email;
        this.security_pin = security_pin;
        this.invitation_code = invitation_code;
        this.password = password;
        this.return_redirect = return_redirect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurity_pin() {
        return security_pin;
    }

    public void setSecurity_pin(String security_pin) {
        this.security_pin = security_pin;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReturn_redirect() {
        return return_redirect;
    }

    public void setReturn_redirect(String return_redirect) {
        this.return_redirect = return_redirect;
    }
}
