package com.bharatapp.retrofit.NavFragment;

import com.bharatapp.retrofit.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("Auth/register")
    Call<RegisterResponse>register(
            @Field("email")String email,
            @Field("name")String name,
            @Field("number")String contact,
            @Field("password")String password
    );
}
