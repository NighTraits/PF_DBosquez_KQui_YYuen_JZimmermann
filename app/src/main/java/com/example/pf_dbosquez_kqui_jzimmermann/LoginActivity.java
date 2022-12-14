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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                        String nombre = response.body().getUsuario().getNombres() + " " + response.body().getUsuario().getApellidos();
                        int rol = response.body().getUsuario().getRole();
                        int id=0;

                        if(rol == 2){
                            id = response.body().getUsuario().getDocenteId();
                        } else if (rol == 3) {
                            id = response.body().getUsuario().getEstudianteId();
                        }

                        Bundle b = new Bundle();
                        b.putString("nombre", nombre);
                        b.putInt("id", id);
                        b.putInt("rol", rol);

                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        i.putExtras(b);

                        startActivity(i);

                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this,"Oops! Something went wrong!",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void SignIn(View v){
        startActivity(new Intent(LoginActivity.this,SignInActivity.class));
    }
}