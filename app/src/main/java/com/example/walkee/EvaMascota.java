package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EvaMascota extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextInputEditText editTextComments;
    private Button buttonSend;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evamascota);

        // Declarar todos los elementos del layout
        ratingBar = findViewById(R.id.ratingBar);
        editTextComments = findViewById(R.id.editTextComments);
        buttonSend = findViewById(R.id.buttonSend);
        buttonBack = findViewById(R.id.buttonBack);

        // Configurar listener para el RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    String evaluation = getEvaluationDescription((int) rating);
                    Toast.makeText(EvaMascota.this, "Tu evaluación es: " + evaluation, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar listener para el botón "Enviar"
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog();
            }
        });

        // Configurar listener para el botón "Volver"
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EvaMascota.this, WalkerActivity.class);
                startActivity(intent);
                finish(); //
            }
        });
    }

    // Método para obtener la descripción de la evaluación según el número de estrellas
    private String getEvaluationDescription(int rating) {
        switch (rating) {
            case 1:
                return "Pésimo";
            case 2:
                return "Mal";
            case 3:
                return "Normal";
            case 4:
                return "Bien";
            case 5:
                return "Excelente";
            default:
                return "";
        }
    }

    // Método para mostrar el AlertDialog de éxito al enviar comentarios
    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Comentarios enviados exitosamente")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Limpiar el campo de comentarios
                        editTextComments.setText("");
                    }
                });
        builder.create().show();
    }
}
