package com.example.pf_dbosquez_kqui_jzimmermann.Services.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("asignatura")
    @Expose
    private String asignatura;

    @SerializedName("codigo_asignatura")
    @Expose
    private String codigoAsignatura;

    @SerializedName("docente_id")
    @Expose
    private int docenteId;

    @SerializedName("grupo")
    @Expose
    private String grupo;

    @SerializedName("periodo")
    @Expose
    private String periodo;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
