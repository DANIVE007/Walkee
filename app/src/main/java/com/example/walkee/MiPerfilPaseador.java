package com.example.walkee;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MiPerfilPaseador extends AppCompatActivity {

    private EditText editTextNombres, editTextApellidos, editTextFechaNacimiento,
            editTextRut, editTextEmail, editTextGenero, editTextContrasena;

    private Button buttonBack, buttonNext;

    private String nombresOriginal, apellidosOriginal, fechaNacimientoOriginal,
            rutOriginal, emailOriginal, generoOriginal, contrasenaOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_paseador);

        // Vincular vistas del XML
        editTextNombres = findViewById(R.id.editTextText2);
        editTextApellidos = findViewById(R.id.editTextText3);
        editTextFechaNacimiento = findViewById(R.id.editTextText5);
        editTextRut = findViewById(R.id.editTextText4);
        editTextEmail = findViewById(R.id.editTextText6);
        editTextGenero = findViewById(R.id.editTextText8);
        editTextContrasena = findViewById(R.id.editTextText7);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        // Guardar valores originales
        nombresOriginal = editTextNombres.getText().toString();
        apellidosOriginal = editTextApellidos.getText().toString();
        fechaNacimientoOriginal = editTextFechaNacimiento.getText().toString();
        rutOriginal = editTextRut.getText().toString();
        emailOriginal = editTextEmail.getText().toString();
        generoOriginal = editTextGenero.getText().toString();
        contrasenaOriginal = editTextContrasena.getText().toString();

        // Configurar el botón Atrás para volver a WalkerActivity.java
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Monitorear cambios en los EditText para activar el botón Editar
        editTextNombres.addTextChangedListener(textWatcher);
        editTextApellidos.addTextChangedListener(textWatcher);
        editTextFechaNacimiento.addTextChangedListener(textWatcher);
        editTextRut.addTextChangedListener(textWatcher);
        editTextEmail.addTextChangedListener(textWatcher);
        editTextGenero.addTextChangedListener(textWatcher);
        editTextContrasena.addTextChangedListener(textWatcher);

        // Configurar el botón Editar para mostrar un AlertDialog y volver a WalkerActivity.java
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MiPerfilPaseador.this);
                builder.setTitle("Datos Modificados")
                        .setMessage("Sus datos han sido modificados.")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Volver a WalkerActivity.java
                                onBackPressed();
                            }
                        })
                        .show();
            }
        });
    }

    // TextWatcher para monitorear cambios en EditText y activar el botón Editar
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Verificar si se han realizado cambios
            boolean cambiosRealizados = !editTextNombres.getText().toString().equals(nombresOriginal)
                    || !editTextApellidos.getText().toString().equals(apellidosOriginal)
                    || !editTextFechaNacimiento.getText().toString().equals(fechaNacimientoOriginal)
                    || !editTextRut.getText().toString().equals(rutOriginal)
                    || !editTextEmail.getText().toString().equals(emailOriginal)
                    || !editTextGenero.getText().toString().equals(generoOriginal)
                    || !editTextContrasena.getText().toString().equals(contrasenaOriginal);

            // Activar/desactivar el botón Editar
            buttonNext.setEnabled(cambiosRealizados);
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Aquí puedes realizar cualquier acción adicional al volver a WalkerActivity.java
    }
}
