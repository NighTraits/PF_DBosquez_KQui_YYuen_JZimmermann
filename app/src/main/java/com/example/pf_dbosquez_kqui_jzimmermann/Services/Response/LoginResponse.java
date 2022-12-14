package com.example.pf_dbosquez_kqui_jzimmermann.Services.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("nombres")
    @Expose
    private String nombres;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("role")
    @Expose
    private int role;

    @SerializedName("docente_id")
    @Expose
    private int docenteId;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }
}
