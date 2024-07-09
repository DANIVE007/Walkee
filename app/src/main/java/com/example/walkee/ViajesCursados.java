package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViajesCursados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes_cursados);

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a WalkerActivity
                Intent intent = new Intent(ViajesCursados.this, WalkerActivity.class);
                startActivity(intent);
                finish(); // Cerrar la actividad actual para evitar volver atrás
            }
        });
    }
}
