package com.example.freedomtech;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDeActivity extends AppCompatActivity {

    Button buttonInfo, buttonTerminos, buttonVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        buttonInfo = findViewById(R.id.buttonInfo);
        buttonTerminos = findViewById(R.id.buttonTerminos);
        buttonVersion = findViewById(R.id.buttonVersion);

    }

    public void Terminos(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Términos y Condiciones");

        builder.setMessage("Los terminos de privacidad y condiciones estan bajo la responsabilidad de FreedomTech S.A. pudiendose estos cambiar cuando la compañia lo viese necesario\n" +
                "\n" +
                "Cualquier modificacion en la aplicacion o mal uso conllevara una sancion hacia la parsona que hace dicha accion, asi como su baneo permanente de la aplicacion," +
                " pudiendo acarrear consecuencias legales.\n"
                );

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Declinar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog dialog = builder.create();

        dialog.show();
    }

    public void Sobre(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Freedom Tech");

        builder.setMessage("Freedom Tech es una aplicacion para crear presupuestos personalizados sobre pcs, y con ello poder organizar de forma sencilla para cuando deseemos adquirirlo \n"+
                "\n" +
                "Los presupuestos se guardan en una base de datos externa, lo que aporta fiabilidad de no perder los datos y poderlos consultar en cualquier momento ");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Declinar", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog dialog = builder.create();

        dialog.show();
    }

    public void Version(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Version");

        builder.setMessage("v1.1b");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Declinar", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog dialog = builder.create();

        dialog.show();
    }

}
