package com.example.pf_dbosquez_kqui_jzimmermann;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pf_dbosquez_kqui_jzimmermann.Services.ApiClient;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Models.User;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Request.LoginRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Response.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    private ArrayList<User> userModels=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

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

            Call<LoginResponse> call = ApiClient.getUserService().userLogin(loginRequest);
            call.enqueue(new Callback<LoginResponse>() {

                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body()!=null) {

                        String apellido = response.body().getUsuario().getApellidos();
                        Toast.makeText(LoginActivity.this,"data: " + apellido,Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this,"Oops! Something went wrong!",Toast.LENGTH_SHORT).show();
                }

            });
        }
    }

    public void SignIn(View v){
        startActivity(new Intent(LoginActivity.this,SignInActivity.class));
    }
}