package com.example.pf_dbosquez_kqui_jzimmermann.Services;

import com.example.pf_dbosquez_kqui_jzimmermann.Services.Request.LoginRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Request.RegisterRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Response.LoginResponse;
import com.example.pf_dbosquez_kqui_jzimmermann.Services.Response.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    /*@GET("estudiantes/all")
    Call<List<Student>> getStudents();

    @GET("grupos/all")
    Call<List<Group>> getGroups();

    @GET("grupos/estudiante/{eid}")
    Call<List<Group>> getGroupsByStudentId(@Path("eid") int id);

    @GET("grupos/profesor/{pid}")
    Call<List<Group>> getGroupsByProfesor(@Path("pid") int pid);

    @GET("estudiantes/grupos/{gaId}")
    Call<List<Student>> getStudentsByGroup(@Path("gaId") int gaId);

    @GET("estudiantes/asistencia/{gaId}")
    Call<List<Student>> getStudentsAttendeByGroup(@Path("gaId") int gaId);

    @GET("estudiante/asistencia/{gaId}/{eId}")
    Call<List<Student>> getStudentsAttendeByGroup(@Path("gaId") int gaId, @Path("eId") int eId);

    @POST("estudiante/asistencia")
    Call<Student> postStudentsSubject(@Body Attendance body);
*/
    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("registrar")
    Call<RegisterResponse> createUser(@Body RegisterRequest registerRequest);

}
