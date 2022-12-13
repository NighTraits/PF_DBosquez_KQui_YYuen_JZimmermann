package com.example.pf_dbosquez_kqui_jzimmermann;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pf_dbosquez_kqui_jzimmermann.Adapters.AsistenciaListViewAdapter;
import com.example.pf_dbosquez_kqui_jzimmermann.Adapters.Estudiantes;
import com.example.pf_dbosquez_kqui_jzimmermann.Helpers.Archivos;

import java.util.ArrayList;
import java.util.List;

public class ListadoAsistenciaActivity extends AppCompatActivity {

    ListView lstAsistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list);

        lstAsistencia= (ListView)findViewById(R.id.lstAsistencia);

        this.LlenarListview();

    }

    private void LlenarListview() {
        String datos = new Archivos(getApplicationContext()).LeerArchivo("Asistencia20221LS142.txt");
        List<Estudiantes> estudiantes = ConvertArchivoToList(datos);

        AsistenciaListViewAdapter adapter = new AsistenciaListViewAdapter(getApplicationContext(),estudiantes);
        lstAsistencia.setAdapter(adapter);
    }

    private List<Estudiantes> ConvertArchivoToList(String datos) {
        List<Estudiantes> lstEstudiantes = new ArrayList<>();
        String[] estudiantes = datos.split("\\~");
        for (String estudiante : estudiantes){
            String[] campos = estudiante.split("\\|");
            Estudiantes est = new Estudiantes(
                    campos[0].substring(3),
                    "",
                    campos[2].substring(3),
                    campos[3].substring(3)
            );
            lstEstudiantes.add(est);
        }

        return lstEstudiantes;
    }
}