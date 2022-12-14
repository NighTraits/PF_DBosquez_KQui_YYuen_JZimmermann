package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    TextView txtTitle;
    String name, apellido;
    int id, role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        Bundle b = getIntent().getExtras();

        if (b != null){
            this.LoadTextViewBundle(b);
        }else{
            this.LoadTextView();
        }

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("Bienvenido " + name + " " + apellido);

    }

    private void LoadTextView() {
        txtTitle.setText(" ");
    }

    private void LoadTextViewBundle(Bundle b) {
        name = b.getString("nombre");
        apellido = b.getString("apellido");
        id = b.getInt("id");
        role = b.getInt("rol");
        try {
            switch (role){
                case 1:
                    setContentView(R.layout.activity_menu_admin);
                    break;
                case 2:
                    setContentView(R.layout.activity_menu_profesor);
                    break;

                case 3:
                    setContentView(R.layout.activity_menu_estudent);
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this, "Role: " + role + " Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    public void ViewProfile(View v){
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        Bundle b = new Bundle();
        b.putString("nombre", name);
        b.putString("apellido", apellido);
        b.putInt("id", id);
        b.putInt("rol", role);
        i.putExtras(b);
        startActivity(i);
    }

    public void ReadTag(View v){
        startActivity(new Intent(this, ReadTagNfcActivity.class));
    }
    //Usuario Estudiante: asistencia por asignatura
    public void GetList(View v){
    }

    //Usuario profesor: obtener todos los grupos de la asignatura
    public void GetCourses(View v){
        startActivity(new Intent(this,GroupListActivity.class));
    }

    //Usuario profesor: obtener lista de asistencia por asignatura
    public void GetAttList(View v){
        startActivity(new Intent(this,ListadoAsistenciaActivity.class));
    }

    public void GetAttendance(View v){
        startActivity(new Intent(this, NfcAsistenciaActivity.class));
    }
}
