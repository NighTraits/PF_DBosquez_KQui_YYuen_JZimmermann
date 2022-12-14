package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pf_dbosquez_kqui_jzimmermann.Services.ApiClient;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Request.RegisterRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Response.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    EditText tbName, tbLastName, tbId, tbEmail, tbPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        InitializeControllers();
    }

    private void InitializeControllers(){
        tbName = (EditText) findViewById(R.id.tbName);
        tbLastName = (EditText) findViewById(R.id.tbLastName);
        tbId = (EditText) findViewById(R.id.tbId);
        tbEmail = (EditText) findViewById(R.id.tbEmail);
        tbPassword = (EditText) findViewById(R.id.tbPwd);
    }

    public void Register (View v){
        if(tbName.getText().toString().isEmpty() || tbLastName.getText().toString().isEmpty() || tbId.getText().toString().isEmpty() || tbEmail.getText().toString().isEmpty() || tbPassword.getText().toString().isEmpty()){
            Toast.makeText(SignInActivity.this,"Campos requerido vacíos", Toast.LENGTH_LONG).show();
        } else {
            try {
                RegisterRequest RegisterRequest = new RegisterRequest();
                RegisterRequest.setNombre(tbName.getText().toString());
                RegisterRequest.setApellido(tbLastName.getText().toString());
                RegisterRequest.setCedula(tbId.getText().toString());
                RegisterRequest.setCorreo(tbEmail.getText().toString());
                RegisterRequest.setContrasena(tbPassword.getText().toString());

                Call<RegisterResponse> RegisterResponseCall = ApiClient.getUserService().createUser(RegisterRequest);

                RegisterResponseCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(SignInActivity.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                            RegisterResponse registerResponse = response.body();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SignInActivity.this, "data: " + registerResponse.getMensaje(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignInActivity.this, LoginActivity.class));
                                }
                            }, 700);

                        } else {
                            Toast.makeText(SignInActivity.this, "Registro fallido", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(SignInActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }catch (Exception e){
                Toast.makeText(this, "Error: " + e, Toast.LENGTH_LONG).show();
            }
        }
    }

}
