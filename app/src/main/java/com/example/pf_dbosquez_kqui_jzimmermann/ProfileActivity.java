package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView lblName, lblLastName, lblId, lblRole;
    String name, apellido;
    int role, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        InitializeControllers();
        Intent i = getIntent();
        Bundle b = getIntent().getExtras();

        if (b != null){
            this.LoadTextViewBundle(b);
        }else{
        }


    }

    private void LoadTextViewBundle(Bundle b) {
        name = b.getString("nombre");
        apellido = b.getString("apellido");
        id = b.getInt("id");
        role = b.getInt("rol");

        lblName.setText("Nombre: " + name);
        lblLastName.setText("Apellido: " + apellido);
        lblId.setText("Cédula: " + id);
        switch (role){
            case 1:
                lblRole.setText("Role: Administrador");
                break;
            case 2:
                lblRole.setText("Role: Profesor");
                break;
            case 3:
                lblRole.setText("Role: Estudiante");
                break;
        }
    }

    private void InitializeControllers(){
        lblName = (TextView) findViewById(R.id.lblNombre);
        lblLastName = (TextView) findViewById(R.id.lblLastName);
        lblId = (TextView) findViewById(R.id.lblId);
        lblRole = (TextView) findViewById(R.id.lblRol);

    }
}
