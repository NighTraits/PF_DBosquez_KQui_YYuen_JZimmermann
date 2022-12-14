package com.example.pf_dbosquez_kqui_jzimmermann.Services.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
