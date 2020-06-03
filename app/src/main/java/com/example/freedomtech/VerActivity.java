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

public class VerActivity extends AppCompatActivity {

    Button buttonVerPresupuesto;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        buttonVerPresupuesto = findViewById(R.id.buttonVerPresupuesto);
        listView = findViewById(R.id.listview);

        buttonVerPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();

            }
        });

    }

    private void getData() {

        Intent intent = getIntent();

        String string_usuario_recibido = intent.getStringExtra("string_usuario");

        String url = RecuperarPresupuesto.DATA_URL + string_usuario_recibido;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VerActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(RecuperarPresupuesto.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {

                JSONObject jo = result.getJSONObject(i);

                 String d2 = jo.getString(RecuperarPresupuesto.KEY_descripcion_pc);

                 String d3 = jo.getString(RecuperarPresupuesto.KEY_procesador);
                 String d4 =  jo.getString(RecuperarPresupuesto.KEY_procesador_precio);

                 String d5 = jo.getString(RecuperarPresupuesto.KEY_placa_base);
                 String d6 = jo.getString(RecuperarPresupuesto.KEY_placa_base_precio);

                 String d7 = jo.getString(RecuperarPresupuesto.KEY_memoria_ram);
                 String d8 = jo.getString(RecuperarPresupuesto.KEY_memoria_ram_precio);

                 String d9 = jo.getString(RecuperarPresupuesto.KEY_kit_placa_procesador_ram);
                 String d10 = jo.getString(RecuperarPresupuesto.KEY_kit_precio);

                 String d11 = jo.getString(RecuperarPresupuesto.KEY_disco_duro_ssd);
                 String d12 = jo.getString(RecuperarPresupuesto.KEY_dd_ssd_precio);

                 String d13 = jo.getString(RecuperarPresupuesto.KEY_disco_duro_ssd_2);
                 String d14 = jo.getString(RecuperarPresupuesto.KEY_dd_ssd2_precio);

                 String d15 = jo.getString(RecuperarPresupuesto.KEY_disco_duro_hdd);
                 String d16 = jo.getString(RecuperarPresupuesto.KEY_dd_hdd_precio);

                 String d17 = jo.getString(RecuperarPresupuesto.KEY_disco_duro_hdd_2);
                 String d18 = jo.getString(RecuperarPresupuesto.KEY_dd_hdd2_precio);

                 String d19 = jo.getString(RecuperarPresupuesto.KEY_fuente_alimentacion);
                 String d20 = jo.getString(RecuperarPresupuesto.KEY_fuente_alim_precio);

                 String d21 = jo.getString(RecuperarPresupuesto.KEY_torre_caja);
                 String d22 = jo.getString(RecuperarPresupuesto.KEY_torre_caja_precio);

                 String d23 = jo.getString(RecuperarPresupuesto.KEY_refrigeracion);
                 String d24 = jo.getString(RecuperarPresupuesto.KEY_refrigeracion_precio);

                 String d25 = jo.getString(RecuperarPresupuesto.KEY_tarjeta_grafica);
                 String d26 = jo.getString(RecuperarPresupuesto.KEY_tarjeta_grafica_precio);

                 String d27 = jo.getString(RecuperarPresupuesto.KEY_tarjeta_red);
                 String d28 = jo.getString(RecuperarPresupuesto.KEY_tarjeta_red_precio);

                 String d29 = jo.getString(RecuperarPresupuesto.KEY_monitor);
                 String d30 = jo.getString(RecuperarPresupuesto.KEY_monitor_precio);

                 String d31 = jo.getString(RecuperarPresupuesto.KEY_teclado);
                 String d32 = jo.getString(RecuperarPresupuesto.KEY_teclado_precio);

                 String d33 = jo.getString(RecuperarPresupuesto.KEY_raton);
                 String d34 = jo.getString(RecuperarPresupuesto.KEY_raton_precio);

                 String d35 = jo.getString(RecuperarPresupuesto.KEY_cascos);
                 String d36 = jo.getString(RecuperarPresupuesto.KEY_cascos_precio);

                 String d37 = jo.getString(RecuperarPresupuesto.KEY_otros);
                 String d38 = jo.getString(RecuperarPresupuesto.KEY_otros_precio);

                 String d39 = jo.getString(RecuperarPresupuesto.KEY_precio_total);


                final HashMap<String, String> datos = new HashMap<>();

                datos.put(RecuperarPresupuesto.KEY_descripcion_pc, d2);

                datos.put(RecuperarPresupuesto.KEY_procesador, d3);
                datos.put(RecuperarPresupuesto.KEY_procesador_precio, d4);

                datos.put(RecuperarPresupuesto.KEY_placa_base, d5);
                datos.put(RecuperarPresupuesto.KEY_placa_base_precio, d6);

                datos.put(RecuperarPresupuesto.KEY_memoria_ram, d7);
                datos.put(RecuperarPresupuesto.KEY_memoria_ram_precio, d8);

                datos.put(RecuperarPresupuesto.KEY_kit_placa_procesador_ram, d9);
                datos.put(RecuperarPresupuesto.KEY_kit_precio, d10);

                datos.put(RecuperarPresupuesto.KEY_disco_duro_ssd, d11);
                datos.put(RecuperarPresupuesto.KEY_dd_ssd_precio, d12);

                datos.put(RecuperarPresupuesto.KEY_disco_duro_ssd_2, d13);
                datos.put(RecuperarPresupuesto.KEY_dd_ssd2_precio, d14);

                datos.put(RecuperarPresupuesto.KEY_disco_duro_hdd, d15);
                datos.put(RecuperarPresupuesto.KEY_dd_hdd_precio, d16);

                datos.put(RecuperarPresupuesto.KEY_disco_duro_hdd_2, d17);
                datos.put(RecuperarPresupuesto.KEY_dd_hdd2_precio, d18);

                datos.put(RecuperarPresupuesto.KEY_fuente_alimentacion, d19);
                datos.put(RecuperarPresupuesto.KEY_fuente_alim_precio, d20);

                datos.put(RecuperarPresupuesto.KEY_torre_caja, d21);
                datos.put(RecuperarPresupuesto.KEY_torre_caja_precio, d22);

                datos.put(RecuperarPresupuesto.KEY_refrigeracion, d23);
                datos.put(RecuperarPresupuesto.KEY_refrigeracion_precio, d24);

                datos.put(RecuperarPresupuesto.KEY_tarjeta_grafica, d25);
                datos.put(RecuperarPresupuesto.KEY_tarjeta_grafica_precio, d26);

                datos.put(RecuperarPresupuesto.KEY_tarjeta_red, d27);
                datos.put(RecuperarPresupuesto.KEY_tarjeta_red_precio, d28);

                datos.put(RecuperarPresupuesto.KEY_monitor, d29);
                datos.put(RecuperarPresupuesto.KEY_monitor_precio, d30);

                datos.put(RecuperarPresupuesto.KEY_teclado, d31);
                datos.put(RecuperarPresupuesto.KEY_teclado_precio, d32);

                datos.put(RecuperarPresupuesto.KEY_raton, d33);
                datos.put(RecuperarPresupuesto.KEY_raton_precio, d34);

                datos.put(RecuperarPresupuesto.KEY_cascos, d35);
                datos.put(RecuperarPresupuesto.KEY_cascos_precio, d36);

                datos.put(RecuperarPresupuesto.KEY_otros, d37);
                datos.put(RecuperarPresupuesto.KEY_otros_precio, d38);

                datos.put(RecuperarPresupuesto.KEY_precio_total, d39);


                list.add(datos);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }
        ListAdapter adapter = new SimpleAdapter(

                VerActivity.this, list, R.layout.activity_mylist,

                new String[]{
                RecuperarPresupuesto.KEY_descripcion_pc,

                RecuperarPresupuesto.KEY_procesador,
                RecuperarPresupuesto.KEY_procesador_precio,

                RecuperarPresupuesto.KEY_placa_base,
                RecuperarPresupuesto.KEY_placa_base_precio,

                RecuperarPresupuesto.KEY_memoria_ram,
                RecuperarPresupuesto.KEY_memoria_ram_precio,

                RecuperarPresupuesto.KEY_kit_placa_procesador_ram,
                RecuperarPresupuesto.KEY_kit_precio,

                RecuperarPresupuesto.KEY_disco_duro_ssd,
                RecuperarPresupuesto.KEY_dd_ssd_precio,

                RecuperarPresupuesto.KEY_disco_duro_ssd_2,
                RecuperarPresupuesto.KEY_dd_ssd2_precio,

                RecuperarPresupuesto.KEY_disco_duro_hdd,
                RecuperarPresupuesto.KEY_dd_hdd_precio,

                RecuperarPresupuesto.KEY_disco_duro_hdd_2,
                RecuperarPresupuesto.KEY_dd_hdd2_precio,

                RecuperarPresupuesto.KEY_fuente_alimentacion,
                RecuperarPresupuesto.KEY_fuente_alim_precio,

                RecuperarPresupuesto.KEY_torre_caja,
                RecuperarPresupuesto.KEY_torre_caja_precio,

                RecuperarPresupuesto.KEY_refrigeracion,
                RecuperarPresupuesto.KEY_refrigeracion_precio,

                RecuperarPresupuesto.KEY_tarjeta_grafica,
                RecuperarPresupuesto.KEY_tarjeta_grafica_precio,

                RecuperarPresupuesto.KEY_tarjeta_red,
                RecuperarPresupuesto.KEY_tarjeta_red_precio,

                RecuperarPresupuesto.KEY_monitor,
                RecuperarPresupuesto.KEY_monitor_precio,

                RecuperarPresupuesto.KEY_teclado,
                RecuperarPresupuesto.KEY_teclado_precio,

                RecuperarPresupuesto.KEY_raton,
                RecuperarPresupuesto.KEY_raton_precio,

                RecuperarPresupuesto.KEY_cascos,
                RecuperarPresupuesto.KEY_cascos_precio,

                RecuperarPresupuesto.KEY_otros,
                RecuperarPresupuesto.KEY_otros_precio,

                RecuperarPresupuesto.KEY_precio_total},

                new int[]{
                        R.id.descripcion,

                        R.id.procesador,
                        R.id.precioProcesador,

                        R.id.placa,
                        R.id.precioPlaca,

                        R.id.memoria,
                        R.id.precioMemoria,

                        R.id.kit,
                        R.id.precioKit,

                        R.id.SSD,
                        R.id.precioSSD,

                        R.id.SSD2,
                        R.id.precioSSD2,

                        R.id.HDD,
                        R.id.precioHDD,

                        R.id.HDD2,
                        R.id.precioHDD2,

                        R.id.fuente,
                        R.id.precioFuente,

                        R.id.torre,
                        R.id.precioTorre,

                        R.id.refrigeracion,
                        R.id.precioRefrigeracion,

                        R.id.gpu,
                        R.id.precioGPU,

                        R.id.network,
                        R.id.precioNetwork,

                        R.id.monitor,
                        R.id.precioMonitor,

                        R.id.teclado,
                        R.id.precioTeclado,

                        R.id.raton,
                        R.id.precioRaton,

                        R.id.cascos,
                        R.id.precioCascos,

                        R.id.otros,
                        R.id.precioOtros,

                        R.id.precioTotal});

        listView.setAdapter(adapter);

    }

}
