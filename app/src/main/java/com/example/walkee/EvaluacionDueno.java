package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EvaluacionDueno extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextInputEditText editTextComments;
    private Button buttonSend, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_dueno);

        ratingBar = findViewById(R.id.ratingBar);
        editTextComments = findViewById(R.id.editTextComments);
        buttonSend = findViewById(R.id.buttonSend);
        buttonBack = findViewById(R.id.buttonBack);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String ratingMessage;
                switch ((int) rating) {
                    case 1:
                        ratingMessage = "Pésimo";
                        break;
                    case 2:
                        ratingMessage = "Malo";
                        break;
                    case 3:
                        ratingMessage = "Medio";
                        break;
                    case 4:
                        ratingMessage = "Bueno";
                        break;
                    case 5:
                        ratingMessage = "Excelente";
                        break;
                    default:
                        ratingMessage = "";
                        break;
                }
                Toast.makeText(EvaluacionDueno.this, ratingMessage, Toast.LENGTH_SHORT).show();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = editTextComments.getText().toString();
                // Aquí puedes añadir el código para enviar los comentarios, por ejemplo, a una base de datos
                Toast.makeText(EvaluacionDueno.this, "Comentarios enviados", Toast.LENGTH_SHORT).show();
                editTextComments.setText(""); // Borra el texto escrito
                editTextComments.setHint("Escribir Comentarios"); // Restablece el hint
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EvaluacionDueno.this, OwnerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
