package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WalkerActivity extends AppCompatActivity {

    private Button buttonWallet, buttonRideRequests, buttonMessaging,
            buttonTerms, buttonTutorials, buttonLogout, buttonPerfil, buttonTutoriales, buttonPaseos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walker_activity);

        // Initialize buttons
        buttonWallet = findViewById(R.id.buttonWallet);
        buttonRideRequests = findViewById(R.id.buttonRideRequests);
        buttonMessaging = findViewById(R.id.buttonMessaging);
        buttonTerms = findViewById(R.id.buttonTerms);
        buttonTutorials = findViewById(R.id.buttonTutorials);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonPerfil = findViewById(R.id.buttonTutorials2);
        buttonTutoriales = findViewById(R.id.buttonTutorials);
        buttonPaseos = findViewById(R.id.buttonTutorials3);

        // Set click listeners
        buttonWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action for Ver mi Wallet button
                Intent intent = new Intent(WalkerActivity.this, MiWallet.class);
                startActivity(intent);
                showToast("Ver mi Wallet clicked");
            }
        });

        buttonRideRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, SolicitudPaseosPaseador.class);
                startActivity(intent);
                // Perform action for Solicitud de Paseos button
                showToast("Solicitud de Paseos clicked");
            }
        });

        buttonMessaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, ChatActivity.class);
                startActivity(intent);
                // Perform action for Mensajería button
                showToast("Mensajería clicked");
            }
        });

        buttonTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, TerminosCondicionesDueno.class);
                startActivity(intent);
                // Perform action for Términos y Condiciones button
                showToast("Términos y Condiciones clicked");
            }
        });

        buttonTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action for Tutoriales button
                showToast("Tutoriales clicked");
            }
        });

        buttonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, MiPerfilPaseador.class);
                startActivity(intent);
                // Perform action for Mi Perfil button
                showToast("Mi Perfil clicked");
            }
        });

        buttonTutoriales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, Tutoriales.class);
                startActivity(intent);
                // Perform action for Tutoriales button
                showToast("Tutoriales clicked");
            }
        });

        buttonPaseos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkerActivity.this, ViajesCursados.class);
                startActivity(intent);
                // Perform action for Paseos en Curso button
                showToast("Paseos en Curso clicked");
            }
        });

        // Botón "Cerrar Sesión"
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(WalkerActivity.this)
                        .setTitle("Cerrar Sesión")
                        .setMessage("¿Está seguro de querer cerrar sesión?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(WalkerActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                                showToast("Cerrar Sesión");
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
