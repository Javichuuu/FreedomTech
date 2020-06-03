package com.example.freedomtech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class PrincipalActivity extends AppCompatActivity {

    Button buttonCrear, buttonVer, buttonBorrar;

    String url = "https://rogdomain.ddns.net:8860/freedomtech/borrarpresupuesto.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        buttonCrear = findViewById(R.id.buttonCrear);
        buttonVer = findViewById(R.id.buttonVer);

    }

    //METODO CREAR PRESUPUESTO

    public void CrearPresupuesto(View view){

        Intent intent = getIntent();

        String string_usuario_recivido = intent.getStringExtra("string_usuario");

        Intent intent2 = new Intent(this, CrearActivity.class);

        intent2.putExtra("string_usuario", string_usuario_recivido);

        startActivity(intent2);

    }

    //METODO VER PRESUPUESTO

    public void VerPresupuesto(View view){

        Intent intent3 = getIntent();

        String string_usuario_recivido = intent3.getStringExtra("string_usuario");

        Intent intent4 = new Intent(this, VerActivity.class);

        intent4.putExtra("string_usuario", string_usuario_recivido);

        startActivity(intent4);

    }

    //METODO BORRAR PRESUPUESTO

    public void BorrarPresupuesto(View view){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Borrando...");

        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                if(response.equalsIgnoreCase("Presupuesto borrado")){

                    Toast.makeText(PrincipalActivity.this, response, Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(PrincipalActivity.this, response, Toast.LENGTH_SHORT).show();

                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(PrincipalActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                Intent intent = getIntent();

                String string_usuario_recivido = intent.getStringExtra("string_usuario");

                Intent intent2 = new Intent(getApplicationContext(), PrincipalActivity.class);

                intent2.putExtra("string_usuario", string_usuario_recivido);

                params.put("usuario", string_usuario_recivido);

                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(PrincipalActivity.this);
        requestQueue.add(request);

    }

    //METODO PARA OBTENER MENU

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //METODO ITEMS DEL MENU

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.itemAcerca:
                Intent intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
                break;

            case R.id.itemDatos:
                Intent recuperarUsuario = getIntent();

                String string_usuario_recibido2 = recuperarUsuario.getStringExtra("string_usuario");

                Intent intent10 = new Intent(this, DatosActivity.class);

                intent10.putExtra("string_usuario", string_usuario_recibido2);

                startActivity(intent10);

                break;

            case R.id.itemCerrarSesion:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}

