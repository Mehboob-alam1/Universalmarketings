package com.mehboob.universalmarketings.Models;

import com.google.gson.annotations.SerializedName;

public class InvitaionCode {

    @SerializedName("")
    String invitationCode;

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
}
