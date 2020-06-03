package com.example.freedomtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DatosActivity extends AppCompatActivity {

    Button buttonVerCuenta;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        buttonVerCuenta = findViewById(R.id.buttonVerCuenta);
        listView = findViewById(R.id.listview);

        buttonVerCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();

            }
        });

    }

    private void getData() {

        Intent intent = getIntent();

        String string_usuario_recibido = intent.getStringExtra("string_usuario");

        String url = RecuperarDatos.DATA_URL + string_usuario_recibido;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DatosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(RecuperarDatos.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {

                JSONObject jo = result.getJSONObject(i);

                String usuario = jo.getString(RecuperarDatos.KEY_USUARIO);
                String email = jo.getString(RecuperarDatos.KEY_EMAIL);
                String contrasena = jo.getString(RecuperarDatos.KEY_CONTRASENA);

                final HashMap<String, String> datos = new HashMap<>();

                datos.put(RecuperarDatos.KEY_USUARIO, usuario);
                datos.put(RecuperarDatos.KEY_EMAIL, email);
                datos.put(RecuperarDatos.KEY_CONTRASENA, contrasena);

                list.add(datos);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }
        ListAdapter adapter = new SimpleAdapter(

                DatosActivity.this, list, R.layout.activity_mylistcuenta,

                new String[]{RecuperarDatos.KEY_USUARIO, RecuperarDatos.KEY_EMAIL, RecuperarDatos.KEY_CONTRASENA},

                new int[]{R.id.usuario, R.id.correo, R.id.contrasena});

        listView.setAdapter(adapter);

    }

}
