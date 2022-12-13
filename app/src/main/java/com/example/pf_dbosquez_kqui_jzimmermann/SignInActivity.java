package com.example.pf_dbosquez_kqui_jzimmermann;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.pf_dbosquez_kqui_jzimmermann.Adapters.User;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {
    EditText editTextUsername, editTextLastName,  editTextCedula, editTextCorreo, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //if the user is already logged in we will directly start the MainActivity (profile) activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        editTextUsername = findViewById(R.id.tbName);
        editTextLastName = findViewById(R.id.tbLastName);
        editTextCedula = findViewById(R.id.tbId);
        editTextCorreo = findViewById(R.id.tbEmail);
        editTextPassword = findViewById(R.id.tbPwd);


        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                registerUser();
            }
        });

        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on textview that already register open LoginActivity
                finish();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
            }
        });

    }

    private void registerUser() {
        final String username = editTextUsername.getText().toString().trim();
        final String lastname = editTextLastName.getText().toString().trim();
        final String cedula = editTextCedula.getText().toString().trim();
        final String email = editTextCorreo.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();


        //first we will do the validations
        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(lastname)) {
            editTextLastName.setError("Please enter lastname");
            editTextLastName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(cedula)) {
            editTextCedula.setError("Please enter your id");
            editTextCedula.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextCorreo.setError("Please enter your email");
            editTextCorreo.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            editTextPassword.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);
                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                User user = new User(
                                        userJson.getString("nombre"),
                                        userJson.getString("apellido"),
                                        userJson.getString("cedula"),
                                        userJson.getString("correo")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", username);
                params.put("apellido", lastname);
                params.put("cedula", cedula);
                params.put("email", email);
                params.put("contrasena", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
