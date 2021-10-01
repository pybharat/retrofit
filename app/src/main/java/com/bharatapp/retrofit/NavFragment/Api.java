package com.bharatapp.retrofit.NavFragment;

import com.bharatapp.retrofit.ModelPost.RegisterPost;
import com.bharatapp.retrofit.ModelResponse.RegisterResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface Api {

    @POST("Auth/register")
    Call<String>register(
            @Body JsonObject jsonObject
            );
}
