package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class VideoTutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videotutorial);

        // Configurar el botón de atrás
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a ActivityTutoriales
                Intent intent = new Intent(VideoTutorial.this, Tutoriales.class);
                startActivity(intent);
                finish(); // Opcional: cierra la actividad actual
            }
        });

        // Reproducir el GIF de forma constante
        ImageView imageView26 = findViewById(R.id.imageView26);
        Glide.with(this)
                .asGif()
                .load(R.drawable.dogwalker) // Reemplaza con el nombre de tu archivo GIF en la carpeta drawable
                .into(imageView26);
    }
}
