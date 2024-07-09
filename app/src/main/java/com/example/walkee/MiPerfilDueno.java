package com.example.walkee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MiPerfilDueno extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonEdit;
    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextFechaNacimiento;
    private EditText editTextRUT;
    private EditText editTextEmail;
    private EditText editTextTelefono;
    private EditText editTextContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_dueno);

        buttonBack = findViewById(R.id.buttonBack);
        buttonEdit = findViewById(R.id.buttonNext);  // "buttonNext" se refiere al botón "Editar"

        editTextNombre = findViewById(R.id.editTextText2);
        editTextApellidos = findViewById(R.id.editTextText3);
        editTextFechaNacimiento = findViewById(R.id.editTextText5);
        editTextRUT = findViewById(R.id.editTextText4);
        editTextEmail = findViewById(R.id.editTextText6);
        editTextTelefono = findViewById(R.id.editTextText8);
        editTextContrasena = findViewById(R.id.editTextText7);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Regresa a la actividad anterior
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditConfirmationDialog();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita implementar
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Activa el botón "Editar" si cualquier texto en los EditText cambia
                buttonEdit.setEnabled(true);
                buttonEdit.setText("Guardar");
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita implementar
            }
        };

        // Añade el TextWatcher a todos los EditText
        editTextNombre.addTextChangedListener(textWatcher);
        editTextApellidos.addTextChangedListener(textWatcher);
        editTextFechaNacimiento.addTextChangedListener(textWatcher);
        editTextRUT.addTextChangedListener(textWatcher);
        editTextEmail.addTextChangedListener(textWatcher);
        editTextTelefono.addTextChangedListener(textWatcher);
        editTextContrasena.addTextChangedListener(textWatcher);
    }

    private void showEditConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Editar Datos")
                .setMessage("¿Está seguro de modificar sus datos?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Código para guardar los cambios
                        guardarCambios();
                        // Mostrar mensaje Toast
                        Toast.makeText(MiPerfilDueno.this, "Datos modificados exitosamente", Toast.LENGTH_SHORT).show();
                        // Dirigir a OwnerActivity
                        Intent intent = new Intent(MiPerfilDueno.this, OwnerActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void guardarCambios() {
        // Aquí puedes añadir el código para guardar los cambios, por ejemplo, en una base de datos o en preferencias compartidas
    }
}
