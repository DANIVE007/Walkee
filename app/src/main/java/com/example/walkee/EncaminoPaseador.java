package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EncaminoPaseador extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView titulo1;
    private TextView titulo2;
    private Button cancelarViaje;
    private Button iniciarPaseo;
    private ImageView imageView8;
    private ImageView imageView10;
    private ImageView imageView11;
    private TextInputEditText mensaje;
    private Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encamino_paseador);

        // Declarar todos los elementos del layout
        ratingBar = findViewById(R.id.ratingBar3);
        titulo1 = findViewById(R.id.titulo1);
        titulo2 = findViewById(R.id.titulo2);
        cancelarViaje = findViewById(R.id.cancelarviaje);
        iniciarPaseo = findViewById(R.id.IniciarPaseo);
        imageView8 = findViewById(R.id.imageView8);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        mensaje = findViewById(R.id.mensaje);
        enviarButton = findViewById(R.id.button);

        // Configurar listener para el botón "Iniciar Paseo"
        iniciarPaseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar la imagen en imageView10
                imageView10.setImageResource(R.drawable.paseotiemporeal);

                // Cambiar el texto en titulo1
                titulo1.setText("Laika está              paseando feliz");

                // Cambiar el texto en titulo2
                titulo2.setText("    Tiempo Restante 45 min.");

                // Cambiar el texto y color del botón "Iniciar Paseo"
                iniciarPaseo.setText("Terminar Paseo");
                iniciarPaseo.setBackgroundTintList(getResources().getColorStateList(R.color.brown));

                // Configurar el listener para el botón "Terminar Paseo"
                iniciarPaseo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Mostrar AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(EncaminoPaseador.this);
                        builder.setMessage("Has recibido por este paseo $2.890 que se cargarán a tu cuenta dentro de las próximas 4 horas")
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Redirigir a EvaMascota.java
                                        startActivity(new Intent(EncaminoPaseador.this, EvaMascota.class));
                                        finish(); // Finalizar esta actividad para evitar que el usuario vuelva atrás
                                    }
                                })
                                .setCancelable(false) // Impedir que se cierre el AlertDialog al presionar fuera de él
                                .show();
                    }
                });
            }
        });
    }
}
