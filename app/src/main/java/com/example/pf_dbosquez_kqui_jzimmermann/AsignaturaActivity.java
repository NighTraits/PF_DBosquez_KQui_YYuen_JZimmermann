package com.example.pf_dbosquez_kqui_jzimmermann;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pf_dbosquez_kqui_jzimmermann.Adapters.GrupoLstAdapter;
import com.example.pf_dbosquez_kqui_jzimmermann.Entities.Grupo;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Models.Group;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsignaturaActivity extends AppCompatActivity {

    ListView lstAsignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        InicializarControles();
        /*
        service
                .enqueue(new Callback<List<Group>>() {
                    @Override
                    public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(AsignaturaActivity.this, "No pudimos obtener la informacion de los grupos", Toast.LENGTH_SHORT).show();
                            call.cancel();
                            return;
                        }
                        List<Group> groupList = response.body();
                        if (groupList == null) {
                            Toast.makeText(AsignaturaActivity.this, "No pudimos registrar el listado de grupos", Toast.LENGTH_SHORT).show();
                            call.cancel();
                            return;
                        }
                        LoadListView_Grupos(groupList);
                    }

                    @Override
                    public void onFailure(Call<List<Group>> call, Throwable t) {
                        Toast.makeText(AsignaturaActivity.this, "Error GLA > " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/

    }

    private void InicializarControles(){
        lstAsignaturas = (ListView) findViewById(R.id.lstAsignaturas);

        lstAsignaturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Grupo selectedGroup = ((Grupo) a.getItemAtPosition(position));

            }
        });

    }

    private void LoadListView_Grupos(List<Grupo> groupData) {
        GrupoLstAdapter adapter = new GrupoLstAdapter(this, groupData);
        lstAsignaturas.setAdapter(adapter);
    }

}