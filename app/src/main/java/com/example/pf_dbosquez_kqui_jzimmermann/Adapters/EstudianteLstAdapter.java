package com.example.pf_dbosquez_kqui_jzimmermann.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pf_dbosquez_kqui_jzimmermann.Entities.Estudiante;
import com.example.pf_dbosquez_kqui_jzimmermann.R;

import java.util.List;

public class EstudianteLstAdapter extends ArrayAdapter<Estudiante> {

    private List<Estudiante> student;

    public EstudianteLstAdapter(Context context, List<Estudiante> datos){
        super(context, R.layout.listview_estudiante, datos);
        student = datos;
    }


    public View getView(int position, View view, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_estudiante, null);

        TextView lblNombreEst = (TextView) item.findViewById(R.id.lblNombreEst);
        lblNombreEst.setText((student.get(position).getName() + " " + student.get(position).getLastName()));

        TextView lblCedulaEst = (TextView) item.findViewById(R.id.lblCedulaEst);
        lblCedulaEst.setText(student.get(position).getCedula());

        TextView lblEmailEst = (TextView) item.findViewById(R.id.lblEmailEst);
        lblEmailEst.setText(student.get(position).getEmail());

        return item;
    }
}
