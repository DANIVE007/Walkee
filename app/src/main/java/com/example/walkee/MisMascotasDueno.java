package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MisMascotasDueno extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button buttonBack, buttonNext, buttonmod1, buttonmod2, buttonmod3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_mascotas_dueno);

        // Inicializar vistas
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);
        buttonmod1 = findViewById(R.id.buttonmod1);
        buttonmod2 = findViewById(R.id.buttonmod2);
        buttonmod3 = findViewById(R.id.buttonmod3);

        // Configurar listener para el botón "Atrás"
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a OwnerActivity.java
                startActivity(new Intent(MisMascotasDueno.this, OwnerActivity.class));
                finish();
            }
        });

        // Configurar listener para el botón "Siguiente"
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar que al menos un CheckBox esté seleccionado
                if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                    // Navegar a SolicitudPaseosDueno.java
                    startActivity(new Intent(MisMascotasDueno.this, SolicitudPaseosDueno.class));
                    finish();
                } else {
                    Toast.makeText(MisMascotasDueno.this, "Por favor, seleccione al menos una mascota", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar listeners para los botones "Modificar"
        buttonmod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de "Modificar perfil"
                Toast.makeText(MisMascotasDueno.this, "Modificar perfil", Toast.LENGTH_SHORT).show();
            }
        });
        buttonmod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de "Modificar perfil"
                Toast.makeText(MisMascotasDueno.this, "Modificar perfil", Toast.LENGTH_SHORT).show();
            }
        });
        buttonmod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de "Modificar perfil"
                Toast.makeText(MisMascotasDueno.this, "Modificar perfil", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar listener para habilitar el botón "Siguiente" cuando se seleccione un CheckBox
        View.OnClickListener checkBoxListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext.setEnabled(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked());
            }
        };

        checkBox1.setOnClickListener(checkBoxListener);
        checkBox2.setOnClickListener(checkBoxListener);
        checkBox3.setOnClickListener(checkBoxListener);

        // Botón "Siguiente" inicialmente deshabilitado
        buttonNext.setEnabled(false);
    }
}
