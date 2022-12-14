package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.pf_dbosquez_kqui_jzimmermann.Adapters.User;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_LASTNAME = "keylastname";
    private static final String KEY_CEDULA = "keycedula";
    private static final String KEY_CORREO = "keyemail";
    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(User user) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, user.getNombre());
        editor.putString(KEY_LASTNAME, user.getApellido());
        editor.putString(KEY_CEDULA, user.getCedula());
        editor.putString(KEY_CORREO, user.getCorreo());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_LASTNAME, null),
                sharedPreferences.getString(KEY_CEDULA, null),
                sharedPreferences.getString(KEY_CORREO, null)
        );
    }

}
