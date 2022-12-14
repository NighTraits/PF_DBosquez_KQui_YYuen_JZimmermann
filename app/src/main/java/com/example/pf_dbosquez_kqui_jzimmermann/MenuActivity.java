package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    TextView txtTitle;
    String name;
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
        txtTitle.setText(name);

    }

    private void LoadTextView() {
        txtTitle.setText(" ");
    }

    private void LoadTextViewBundle(Bundle b) {
        name = "Bienvenido " + b.getString("nombre");
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
}
