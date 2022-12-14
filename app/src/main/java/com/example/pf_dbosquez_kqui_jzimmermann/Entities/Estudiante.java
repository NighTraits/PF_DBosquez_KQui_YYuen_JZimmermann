package com.example.pf_dbosquez_kqui_jzimmermann.Entities;

import com.google.gson.annotations.SerializedName;

public class Estudiante {
    @SerializedName("id")
    Integer studentId;
    @SerializedName("nombre")
    String name;
    @SerializedName("apellido")
    String lastName;
    @SerializedName("cedula")
    String Cedula;
    @SerializedName("correo")
    String email;
    @SerializedName("foto_url")
    String photo;

    public Estudiante(Integer studentId, String name, String lastName, String Cedula, String email, String photo) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.Cedula = Cedula;
        this.email = email;
        this.photo = photo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Cedula='" + Cedula + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
