package com.example.pf_dbosquez_kqui_jzimmermann.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pf_dbosquez_kqui_jzimmermann.R;

import java.util.ArrayList;
import java.util.List;

public class AsistenciaListViewAdapter extends ArrayAdapter {

    List<Estudiantes> opciones = new ArrayList();

    public AsistenciaListViewAdapter(@NonNull Context context, @NonNull List<Estudiantes> datos) {
        super(context, R.layout.listview_asistencia_template, datos);

        opciones = datos;
    }

    public View getView(int pos, View v, ViewGroup vgroup){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_asistencia_template,null);

        TextView nombre = item.findViewById(R.id.lblNombre);
        nombre.setText(opciones.get(pos).getNombre());

        TextView cedula = item.findViewById(R.id.lblCedula);
        cedula.setText(opciones.get(pos).getCedula());

        TextView hora = item.findViewById(R.id.lblHora);
        hora.setText(opciones.get(pos).getHora());

        return item;
    }
}
