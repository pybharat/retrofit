package com.bharatapp.retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bharatapp.retrofit.ModelPost.RegisterPost;
import com.bharatapp.retrofit.ModelResponse.RegisterResponse;
import com.bharatapp.retrofit.NavFragment.RetrofitClient;
import com.bharatapp.retrofit.R;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText email,name,number,password;
Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String useremail=email.getText().toString();
        String username=name.getText().toString();
        String usernumber=number.getText().toString();
        String userpassword=password.getText().toString();
        if(useremail.isEmpty())
        {
            email.requestFocus();
            email.setError("Enter Email");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches())
        {
            email.requestFocus();
            email.setError("please enter correct Email");
            return;
        }
        if(username.isEmpty())
        {
            name.requestFocus();
            name.setError("Enter name");
            return;
        }
        if(usernumber.isEmpty())
        {
            number.requestFocus();
            number.setError("Enter Number");
            return;
        }
        if(userpassword.isEmpty())
        {
            password.requestFocus();
            password.setError("Enter Password");
            return;
        }
        if(userpassword.length()<8)
        {
            password.requestFocus();
            password.setError("Minimum 8 characters");
            return;
        }

        RegisterPost registerPost=new RegisterPost(useremail,username,usernumber,userpassword);
        Call<RegisterResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .register(registerPost);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse=response.body();
                if(response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, registerResponse.getUserid()+" "+registerResponse.getCode()+" "+registerResponse.getOtp()+" "+registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}