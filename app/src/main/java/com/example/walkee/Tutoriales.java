package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Tutoriales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoriales);

        // Configurar el botón de atrás
        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a WalkerActivity
                Intent intent = new Intent(Tutoriales.this, WalkerActivity.class);
                startActivity(intent);
                finish(); // Opcional: cierra la actividad actual
            }
        });

        // Configurar el TextView para ir a VideoTutorial
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a VideoTutorial
                Intent intent = new Intent(Tutoriales.this, VideoTutorial.class);
                startActivity(intent);
            }
        });
    }
}
