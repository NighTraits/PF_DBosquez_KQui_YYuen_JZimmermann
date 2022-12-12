package com.example.pf_dbosquez_kqui_jzimmermann.Helpers;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Archivos {

    Context ctx;

    public Archivos(Context ctx){
        this.ctx = ctx;
    }

    public String LeerArchivo(String fileName){
        try
        {
            BufferedReader fin = new BufferedReader( new InputStreamReader(
                    ctx.openFileInput(fileName)));
            String texto = fin.readLine();
            fin.close();
            return texto;
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
        return "";
    }

    public void CrearArchivo(String fileName, String newDatos){
        try
        {
            String oldDatos = this.LeerArchivo(fileName);

            OutputStreamWriter fout = new OutputStreamWriter(
                    ctx.openFileOutput(fileName, Context.MODE_PRIVATE));
            if(oldDatos == ""){
                fout.write(newDatos);
            }else{
                fout.write(oldDatos +"~"+newDatos);
            }
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }

    }
}
