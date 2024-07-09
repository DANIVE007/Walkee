package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OwnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_activity);

        // Botón "Ver mi Perfil"
        Button buttonWallet = findViewById(R.id.buttonWallet);
        buttonWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, MiPerfilDueno.class);
                startActivity(intent);
                // Acción al hacer clic
                showToast("Ver mi Perfil");
            }
        });

        // Botón "Solicitud de Paseos"
        Button buttonRideRequests = findViewById(R.id.buttonRideRequests);
        buttonRideRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, SolicitudPaseosDueno.class);
                startActivity(intent);
                // Acción al hacer clic
                showToast("Solicitud de Paseos");
            }
        });

        // Botón "Ver Mis Mascotas"
        Button buttonMessaging = findViewById(R.id.buttonMessaging);
        buttonMessaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, MisMascotasDueno.class);
                startActivity(intent);
                // Acción al hacer clic
                showToast("Ver Mis Mascotas");
            }
        });

        // Botón "Términos y Condiciones"
        Button buttonTerms = findViewById(R.id.buttonTerms);
        buttonTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, TerminosCondicionesDueno.class);
                startActivity(intent);
                // Acción al hacer clic
                showToast("Términos y Condiciones");
            }
        });

        // Botón "Mensajería"
        Button buttonTutorials = findViewById(R.id.buttonTutorials);
        buttonTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, ChatActivity.class);
                startActivity(intent);
                // Acción al hacer clic
                showToast("Mensajeria");
            }
        });

        // Botón "Cerrar Sesión"
        Button buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(OwnerActivity.this)
                        .setTitle("Cerrar Sesión")
                        .setMessage("¿Está seguro de querer cerrar sesión?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(OwnerActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                                // Acción al hacer clic
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
