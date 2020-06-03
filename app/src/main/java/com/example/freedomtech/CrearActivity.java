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

public class CrearActivity extends AppCompatActivity {

    EditText //editTextUsuario,
            editTextDescripcion,
            editTextProcesador,
            editTextPrecioProcesador,
            editTextPlaca,
            editTextPrecioPlaca,
            editTextMemoria,
            editTextPrecioMemoria,
            editTextKit,
            editTextPrecioKit,
            editTextSSD,
            editTextPrecioSSD,
            editTextSSD2,
            editTextPrecioSSD2,
            editTextHDD,
            editTextPrecioHDD,
            editTextHDD2,
            editTextPrecioHDD2,
            editTextFuente,
            editTextPrecioFuente,
            editTextTorre,
            editTextPrecioTorre,
            editTextRefrigeracion,
            editTextPrecioRefrigeracion,
            editTextGPU,
            editTextPrecioGPU,
            editTextNetwork,
            editTextPrecioNetwork,
            editTextMonitor,
            editTextPrecioMonitor,
            editTextTeclado,
            editTextPrecioTeclado,
            editTextRaton,
            editTextPrecioRaton,
            editTextCascos,
            editTextPrecioCascos,
            editTextOtros,
            editTextPrecioOtros,
            editTextPrecioTotal;

    Button buttonCrearPresupuesto;

    String string_usuario,
            string_descripcion,
            string_procesador,
            string_PrecioProcesador,
            string_Placa,
            string_PrecioPlaca,
            string_Memoria,
            string_PrecioMemoria,
            string_Kit,
            string_PrecioKit,
            string_SSD,
            string_PrecioSSD,
            string_SSD2,
            string_PrecioSSD2,
            string_HDD,
            string_PrecioHDD,
            string_HDD2,
            string_PrecioHDD2,
            string_Fuente,
            string_PrecioFuente,
            string_Torre,
            string_PrecioTorre,
            string_Refrigeracion,
            string_PrecioRefrigeracion,
            string_GPU,
            string_PrecioGPU,
            string_Network,
            string_PrecioNetwork,
            string_Monitor,
            string_PrecioMonitor,
            string_Teclado,
            string_PrecioTeclado,
            string_Raton,
            string_PrecioRaton,
            string_Cascos,
            string_PrecioCascos,
            string_Otros,
            string_PrecioOtros,
            string_PrecioTotal;

    String url = "https://rogdomain.ddns.net:8860/freedomtech/crearpresupuesto.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        //editTextUsuario=findViewById(R.id.editTextUsuario);
        editTextDescripcion=findViewById(R.id.editTextDescripcion);

        //PROCESADOR

        editTextProcesador=findViewById(R.id.editTextProcesador);
        editTextPrecioProcesador=findViewById(R.id.editTextPrecioProcesador);

        //PLACA

        editTextPlaca=findViewById(R.id.editTextPlaca);
        editTextPrecioPlaca=findViewById(R.id.editTextPrecioPlaca);

        //RAM

        editTextMemoria=findViewById(R.id.editTextMemoria);
        editTextPrecioMemoria=findViewById(R.id.editTextPrecioMemoria);

        //KIT

        editTextKit=findViewById(R.id.editTextKit);
        editTextPrecioKit=findViewById(R.id.editTextPrecioKit);

        //SSD

        editTextSSD=findViewById(R.id.editTextSSD);
        editTextPrecioSSD=findViewById(R.id.editTextPrecioSSD);

        //SSD2

        editTextSSD2=findViewById(R.id.editTextSSD2);
        editTextPrecioSSD2=findViewById(R.id.editTextPrecioSSD2);

        //HDD

        editTextHDD=findViewById(R.id.editTextHDD);
        editTextPrecioHDD=findViewById(R.id.editTextPrecioHDD);

        //HDD2

        editTextHDD2=findViewById(R.id.editTextHDD2);
        editTextPrecioHDD2=findViewById(R.id.editTextPrecioHDD2);

        //FUENTE

        editTextFuente=findViewById(R.id.editTextFuente);
        editTextPrecioFuente=findViewById(R.id.editTextPrecioFuente);

        //TORRE

        editTextTorre=findViewById(R.id.editTextTorre);
        editTextPrecioTorre=findViewById(R.id.editTextPrecioTorre);

        //REFRIGERACION

        editTextRefrigeracion=findViewById(R.id.editTextRefrigeracion);
        editTextPrecioRefrigeracion=findViewById(R.id.editTextPrecioRefrigeracion);

        //GPU

        editTextGPU=findViewById(R.id.editTextGPU);
        editTextPrecioGPU=findViewById(R.id.editTextPrecioGPU);

        //NETWORK

        editTextNetwork=findViewById(R.id.editTextNetwork);
        editTextPrecioNetwork=findViewById(R.id.editTextPrecioNetwork);

        //MONITOR

        editTextMonitor=findViewById(R.id.editTextMonitor);
        editTextPrecioMonitor=findViewById(R.id.editTextPrecioMonitor);

        //TECLADO

        editTextTeclado=findViewById(R.id.editTextTeclado);
        editTextPrecioTeclado=findViewById(R.id.editTextPrecioTeclado);

        //RATON

        editTextRaton=findViewById(R.id.editTextRaton);
        editTextPrecioRaton=findViewById(R.id.editTextPrecioRaton);

        //CASCOS

        editTextCascos=findViewById(R.id.editTextCascos);
        editTextPrecioCascos=findViewById(R.id.editTextPrecioCascos);

        //OTROS

        editTextOtros=findViewById(R.id.editTextOtros);
        editTextPrecioOtros=findViewById(R.id.editTextPrecioOtros);

        //PRECIO FINAL

        editTextPrecioTotal=findViewById(R.id.editTextPrecioTotal);

        //editTextUsuario.setText(string_usuario_recivido);

    }

    public void Crear_Presupuesto(View view){

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Creando presupuesto...");

        //String auth_usuario = editTextUsuario.getText().toString();

        /*if (auth_usuario.isEmpty()) {

            editTextUsuario.setError("Ingresa nombre de usuario");

        } else {*/

            progressDialog.show();

            //string_usuario = editTextUsuario.getText().toString().trim();

            string_descripcion = editTextDescripcion.getText().toString().trim();
            string_procesador = editTextProcesador.getText().toString().trim();
            string_PrecioProcesador = editTextPrecioProcesador.getText().toString();
            string_Placa = editTextPlaca.getText().toString();
            string_PrecioPlaca = editTextPrecioPlaca.getText().toString();
            string_Memoria = editTextMemoria.getText().toString();
            string_PrecioMemoria = editTextPrecioMemoria.getText().toString();
            string_Kit = editTextKit.getText().toString();
            string_PrecioKit = editTextPrecioKit.getText().toString();
            string_SSD = editTextSSD.getText().toString();
            string_PrecioSSD = editTextPrecioSSD.getText().toString();
            string_SSD2 = editTextSSD2.getText().toString();
            string_PrecioSSD2 = editTextPrecioSSD2.getText().toString();
            string_HDD = editTextHDD.getText().toString();
            string_PrecioHDD = editTextPrecioHDD.getText().toString();
            string_HDD2 = editTextHDD2.getText().toString();
            string_PrecioHDD2 = editTextPrecioHDD2.getText().toString();
            string_Fuente = editTextFuente.getText().toString();
            string_PrecioFuente = editTextPrecioFuente.getText().toString();
            string_Torre = editTextTorre.getText().toString();
            string_PrecioTorre = editTextPrecioTorre.getText().toString();
            string_Refrigeracion = editTextRefrigeracion.getText().toString();
            string_PrecioRefrigeracion = editTextPrecioRefrigeracion.getText().toString();
            string_GPU = editTextGPU.getText().toString();
            string_PrecioGPU = editTextPrecioGPU.getText().toString();
            string_Network = editTextNetwork.getText().toString();
            string_PrecioNetwork = editTextPrecioNetwork.getText().toString();
            string_Monitor = editTextMonitor.getText().toString();
            string_PrecioMonitor = editTextPrecioMonitor.getText().toString();
            string_Teclado = editTextTeclado.getText().toString();
            string_PrecioTeclado = editTextPrecioTeclado.getText().toString();
            string_Raton = editTextRaton.getText().toString();
            string_PrecioRaton = editTextPrecioRaton.getText().toString();
            string_Cascos = editTextCascos.getText().toString();
            string_PrecioCascos = editTextPrecioCascos.getText().toString();
            string_Otros = editTextOtros.getText().toString();
            string_PrecioOtros = editTextPrecioOtros.getText().toString();
            string_PrecioTotal = editTextPrecioTotal.getText().toString();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    //editTextUsuario.setText("");
                    editTextDescripcion.setText("");

                    editTextProcesador.setText("");
                    editTextPrecioProcesador.setText("");

                    editTextPlaca.setText("");
                    editTextPrecioPlaca.setText("");

                    editTextMemoria.setText("");
                    editTextPrecioMemoria.setText("");

                    editTextKit.setText("");
                    editTextPrecioKit.setText("");

                    editTextSSD.setText("");
                    editTextPrecioSSD.setText("");

                    editTextSSD2.setText("");
                    editTextPrecioSSD2.setText("");

                    editTextHDD.setText("");
                    editTextPrecioHDD.setText("");

                    editTextHDD2.setText("");
                    editTextPrecioHDD2.setText("");

                    editTextFuente.setText("");
                    editTextPrecioFuente.setText("");

                    editTextTorre.setText("");
                    editTextPrecioTorre.setText("");

                    editTextRefrigeracion.setText("");
                    editTextPrecioRefrigeracion.setText("");

                    editTextGPU.setText("");
                    editTextPrecioGPU.setText("");

                    editTextNetwork.setText("");
                    editTextPrecioNetwork.setText("");

                    editTextMonitor.setText("");
                    editTextPrecioMonitor.setText("");

                    editTextTeclado.setText("");
                    editTextPrecioTeclado.setText("");

                    editTextRaton.setText("");
                    editTextPrecioRaton.setText("");

                    editTextCascos.setText("");
                    editTextPrecioCascos.setText("");

                    editTextOtros.setText("");
                    editTextPrecioOtros.setText("");

                    editTextPrecioTotal.setText("");

                    if (response.equalsIgnoreCase("Presupuesto creado")) {

                        Intent intent = getIntent();

                        String string_usuario = intent.getStringExtra("string_usuario");

                        Intent intent2 = new Intent(getApplicationContext(), PrincipalActivity.class);

                        intent2.putExtra("string_usuario", string_usuario);

                        startActivity(intent2);

                        Toast.makeText(CrearActivity.this, response, Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(CrearActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(CrearActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    Intent intent = getIntent();

                    String string_usuario_recivido = intent.getStringExtra("string_usuario");

                    params.put("usuario", string_usuario_recivido);

                    if (string_descripcion == null){

                        string_descripcion="NULL";

                    }else{

                        params.put("descripcion_pc", string_descripcion);

                    }

                    if (editTextProcesador == null){

                        string_procesador="NULL";

                    }else{

                        params.put("procesador", string_procesador);

                    }

                    params.put("procesador_precio", string_PrecioProcesador);

                    if (editTextPlaca == null){

                        string_Placa="NULL";

                    }else{

                        params.put("placa_base", string_Placa);

                    }

                    params.put("placa_base_precio", string_PrecioPlaca);

                    if (editTextMemoria == null){

                        string_Memoria="NULL";

                    }else{

                        params.put("memoria_ram", string_Memoria);

                    }

                    params.put("memoria_ram_precio", string_PrecioMemoria);

                    if (editTextKit == null){

                        string_Kit="NULL";

                    }else{

                        params.put("kit_placa_procesador_ram", string_Kit);

                    }

                    params.put("kit_precio", string_PrecioKit);

                    if (editTextSSD == null){

                        string_SSD="NULL";

                    }else{

                        params.put("disco_duro_ssd", string_SSD);

                    }

                    params.put("dd_ssd_precio", string_PrecioSSD);

                    if (editTextSSD2 == null){

                        string_SSD2="NULL";

                    }else{

                        params.put("disco_duro_ssd_2", string_SSD2);

                    }

                    params.put("dd_ssd2_precio", string_PrecioSSD2);

                    if (editTextHDD == null){

                        string_HDD="NULL";

                    }else{

                        params.put("disco_duro_hdd", string_HDD);

                    }

                    params.put("dd_hdd_precio", string_PrecioHDD);

                    if (editTextHDD2 == null){

                        string_HDD2="NULL";

                    }else{

                        params.put("disco_duro_hdd_2", string_HDD2);

                    }

                    params.put("dd_hdd2_precio", string_PrecioHDD2);

                    if (editTextFuente == null){

                        string_Fuente="NULL";

                    }else{

                        params.put("fuente_alimentacion", string_Fuente);

                    }

                    params.put("fuente_alim_precio", string_PrecioFuente);

                    if (editTextTorre == null){

                        string_Torre="NULL";

                    }else{

                        params.put("torre_caja", string_Torre);

                    }

                    params.put("torre_caja_precio", string_PrecioTorre);

                    if (editTextRefrigeracion == null){

                        string_Refrigeracion="NULL";

                    }else{

                        params.put("refrigeracion", string_Refrigeracion);

                    }

                    params.put("refrigeracion_precio", string_PrecioRefrigeracion);

                    if (editTextGPU == null){

                        string_GPU="NULL";

                    }else{

                        params.put("tarjeta_grafica", string_GPU);

                    }

                    params.put("tarjeta_grafica_precio", string_PrecioGPU);

                    if (editTextNetwork == null){

                        string_Network="NULL";

                    }else{

                        params.put("tarjeta_red", string_Network);

                    }

                    params.put("tarjeta_red_precio", string_PrecioNetwork);

                    if (editTextMonitor == null){

                        string_Monitor="NULL";

                    }else{

                        params.put("monitor", string_Monitor);

                    }

                    params.put("monitor_precio", string_PrecioMonitor);

                    if (editTextTeclado == null){

                        string_Teclado="NULL";

                    }else{

                        params.put("teclado", string_Teclado);

                    }

                    params.put("teclado_precio", string_PrecioTeclado);

                    if (editTextRaton == null){

                        string_Raton="NULL";

                    }else{

                        params.put("raton", string_Raton);

                    }

                    params.put("raton_precio", string_PrecioRaton);

                    if (editTextCascos == null){

                        string_Cascos="NULL";

                    }else{

                        params.put("cascos", string_Cascos);

                    }

                    params.put("cascos_precio", string_PrecioCascos);

                    if (editTextOtros == null){

                        string_Otros="NULL";

                    }else{

                        params.put("otros", string_Otros);

                    }


                    params.put("otros_precio", string_PrecioOtros);

                    params.put("precio_total", string_PrecioTotal);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(CrearActivity.this);
            requestQueue.add(request);

        }

    //}
}
