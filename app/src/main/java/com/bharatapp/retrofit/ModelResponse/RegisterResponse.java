package com.bharatapp.retrofit.ModelResponse;

public class RegisterResponse {
    Integer code,otp,userid;
    String message;

    public RegisterResponse(Integer code, Integer otp, Integer userid, String message) {
        this.code = code;
        this.otp = otp;
        this.userid = userid;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
