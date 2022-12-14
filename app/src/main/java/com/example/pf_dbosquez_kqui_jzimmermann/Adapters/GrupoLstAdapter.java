package com.example.pf_dbosquez_kqui_jzimmermann.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pf_dbosquez_kqui_jzimmermann.R;
import com.example.pf_dbosquez_kqui_jzimmermann.Entities.Grupo;

import java.util.List;

public class GrupoLstAdapter extends ArrayAdapter<Grupo> {

    private List<Grupo> opciones;

    public GrupoLstAdapter(Context context, List<Grupo> datos){
        super(context, R.layout.activity_asignaturas, datos);
        opciones= datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_asignaturas, null);

        TextView lblNombreAsig = (TextView)item.findViewById(R.id.lblNombreAsig);
        lblNombreAsig.setText(opciones.get(position).getSubject());

        TextView lblCodigoAsig = (TextView)item.findViewById(R.id.lblCodigoAsig);
        lblCodigoAsig.setText(opciones.get(position).getGroupName());

        TextView lblGrupoAsig = (TextView)item.findViewById(R.id.lblGrupoAsig);
        lblGrupoAsig.setText(opciones.get(position).getSubjectCode());

        TextView lblPeriodoAsig = (TextView)item.findViewById(R.id.lblPeriodoAsig);
        lblPeriodoAsig.setText(opciones.get(position).getSemester());

        return(item);
    }


}
