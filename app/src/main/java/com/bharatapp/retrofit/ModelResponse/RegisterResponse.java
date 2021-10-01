package com.bharatapp.retrofit.ModelResponse;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("code")
    int code;
    @SerializedName("message")
    String message;
    @SerializedName("otp")
    int otp;
    @SerializedName("userid")
    int userid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
