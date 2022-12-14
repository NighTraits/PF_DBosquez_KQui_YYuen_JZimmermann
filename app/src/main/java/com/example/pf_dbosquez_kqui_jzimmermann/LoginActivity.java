package com.example.pf_dbosquez_kqui_jzimmermann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pf_dbosquez_kqui_jzimmermann.Services.ApiClient;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Request.LoginRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitializeControllers();

    }

    private void InitializeControllers(){
        username = findViewById(R.id.tbEmail);
        password = findViewById(R.id.tbPwd);

    }

    public void Login (View v){

        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(LoginActivity.this,"Campos requerido vacíos", Toast.LENGTH_LONG).show();
        } else {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setEmail(username.getText().toString());
            loginRequest.setPassword(password.getText().toString());

            Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);

            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    if (response.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        LoginResponse loginResponse = response.body();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "data: " + loginResponse.getEmail(), Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(SignInActivity.this,AsistenciaActivity.class).putExtra("data",loginResponse.getUsername()));
                            }
                        }, 700);

                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    public void SignIn(View v){
        startActivity(new Intent(LoginActivity.this,SignInActivity.class));
    }
}