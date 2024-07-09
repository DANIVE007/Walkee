package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorLong;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class EsperandoPaseador extends AppCompatActivity {

    private TextView titulo1, titulo2;
    private Button cancelarviaje, iniciarPaseo, enviar;
    private TextInputEditText mensaje;
    private boolean viajeIniciado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperando_paseador);

        // Inicializar vistas
        titulo1 = findViewById(R.id.titulo1);
        titulo2 = findViewById(R.id.titulo2);
        cancelarviaje = findViewById(R.id.cancelarviaje);
        iniciarPaseo = findViewById(R.id.IniciarPaseo);
        enviar = findViewById(R.id.button);
        mensaje = findViewById(R.id.mensaje);

        // Configurar listener para el botón "Iniciar Paseo"
        iniciarPaseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!viajeIniciado) {
                    // Acción para iniciar el viaje
                    titulo1.setText("Viaje                      Iniciado");
                    titulo2.setText("Juan terminará paseo en 45 min");
                    iniciarPaseo.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(EsperandoPaseador.this, R.color.brown)));
                    iniciarPaseo.setText("Cerrar Viaje");
                    viajeIniciado = true;
                } else {
                    // Acción para terminar el viaje
                    titulo1.setText("Viaje                      Terminado");
                    titulo2.setText("Gracias por Preferirnos!!");
                    iniciarPaseo.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(EsperandoPaseador.this, R.color.green)));
                    iniciarPaseo.setText("Continuar");
                    cancelarviaje.setEnabled(false);
                    iniciarPaseo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(EsperandoPaseador.this, EvaluacionDueno.class);
                            startActivity(intent);
                            }
                        });

                    viajeIniciado = false;
                }
            }
        });

        // Configurar listener para el botón "Cancelar"
        cancelarviaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(EsperandoPaseador.this)
                        .setTitle("Cancelar Viaje")
                        .setMessage("Al momento de cancelar el viaje hay un cobro asociado de $1.500. ¿Desea continuar?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(EsperandoPaseador.this, OwnerActivity.class));
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        // Configurar listener para el botón "Enviar"
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje.setText("Juan: Voy en Camino");
            }
        });
    }
}
