package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SolicitudPaseosDueno extends AppCompatActivity {

    private Switch switch1, switch2, switch3;
    private Button buttonBack, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_paseos_dueno);

        // Inicializar vistas
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        // Configurar listeners
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement back button functionality here
                onBackPressed();
            }
        });

        // Configurar listener para switches
        CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView == switch1) {
                        switch2.setChecked(false);
                        switch2.setEnabled(false);
                        switch3.setChecked(false);
                        switch3.setEnabled(false);
                    } else if (buttonView == switch2) {
                        switch1.setChecked(false);
                        switch1.setEnabled(false);
                        switch3.setChecked(false);
                        switch3.setEnabled(false);
                    } else if (buttonView == switch3) {
                        switch1.setChecked(false);
                        switch1.setEnabled(false);
                        switch2.setChecked(false);
                        switch2.setEnabled(false);
                    }
                } else {
                    switch1.setEnabled(true);
                    switch2.setEnabled(true);
                    switch3.setEnabled(true);
                }

                // Verificar si alguno de los switches está seleccionado
                boolean anySwitchSelected = switch1.isChecked() || switch2.isChecked() || switch3.isChecked();
                buttonNext.setEnabled(anySwitchSelected);
            }
        };

        switch1.setOnCheckedChangeListener(switchListener);
        switch2.setOnCheckedChangeListener(switchListener);
        switch3.setOnCheckedChangeListener(switchListener);

        // Botón Siguiente inicialmente deshabilitado
        buttonNext.setEnabled(false);

        // Configurar listener para el botón "Siguiente"
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a ElijaPlan.java
                startActivity(new Intent(SolicitudPaseosDueno.this, ElijaPlan.class));
                finish();
            }
        });
    }
}
