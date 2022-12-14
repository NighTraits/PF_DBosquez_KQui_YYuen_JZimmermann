package com.example.pf_dbosquez_kqui_jzimmermann.Entities;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Asistencia {
    @SerializedName("id")
    @Nullable
    Integer attendanceId;
    @SerializedName("fecha")
    String date;
    @SerializedName("hora")
    String hour;
    @SerializedName("estudiante_id")
    Integer studentId;
    @SerializedName("grupo_asignatura_id")
    Integer groupSubjectId;
    @SerializedName("estado_asistencia_id")
    Integer subjectStatusId;

    public Asistencia(@Nullable Integer attendanceId, String date, String hour, Integer studentId, Integer groupSubjectId, Integer subjectStatusId) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.hour = hour;
        this.studentId = studentId;
        this.groupSubjectId = groupSubjectId;
        this.subjectStatusId = subjectStatusId;
    }

    @Nullable
    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(@Nullable Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(Integer groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public Integer getSubjectStatusId() {
        return subjectStatusId;
    }

    public void setSubjectStatusId(Integer subjectStatusId) {
        this.subjectStatusId = subjectStatusId;
    }

}
