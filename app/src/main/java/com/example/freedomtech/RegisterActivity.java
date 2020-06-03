package com.example.freedomtech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextEmail, editTextContrasena;
    Button buttonRegister;
    String string_usuario, string_email,string_contrasena;
    String url = "https://rogdomain.ddns.net:8860/freedomtech/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsuario=findViewById(R.id.editTextUsuario);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextContrasena=findViewById(R.id.editTextContrasena);

        buttonRegister=findViewById(R.id.buttonRegister);

    }

    public void Registro(View view){

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Registrando...");

        String auth_usuario = editTextUsuario.getText().toString();
        String auth_email = editTextEmail.getText().toString();
        String auth_contrasena = editTextContrasena.getText().toString();

        if (auth_usuario.isEmpty()) {

            editTextUsuario.setError("Ingresa nombre de usuario");

        } else if (auth_email.isEmpty()) {

            editTextEmail.setError("Ingresa correo electronico");

        } else if (auth_contrasena.isEmpty()) {

            editTextContrasena.setError("Ingresa contraseña");

        } else {

            progressDialog.show();

            string_usuario = editTextUsuario.getText().toString().trim();
            string_email = editTextEmail.getText().toString().trim();
            string_contrasena = editTextContrasena.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    editTextUsuario.setText("");
                    editTextEmail.setText("");
                    editTextContrasena.setText("");

                    if (response.equalsIgnoreCase("Registrado")) {

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("usuario", string_usuario);
                    params.put("email", string_email);
                    params.put("contrasena", string_contrasena);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
            requestQueue.add(request);

        }

    }
}
