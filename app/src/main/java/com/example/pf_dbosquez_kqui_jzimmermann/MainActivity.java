package com.example.pf_dbosquez_kqui_jzimmermann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void GetAttendance(View v){
        startActivity(new Intent(this,AsistenciaActivity.class));
    }

    public void GetList(View v){
        startActivity(new Intent(this,ListadoAsistenciaActivity.class));
    }

    public void SignIn(View v){
        startActivity(new Intent(this,SignInActivity.class));
    }
}