package com.example.walkee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DocPaseador extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText editTelefono1;
    private ImageButton buttonSelectImage1, imageButton, imageButton4, imageButton5;
    private Button buttonBack1, buttonNext1;
    private Spinner spinnerGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_paseador);

        // Inicializar vistas
        editTelefono1 = findViewById(R.id.editTelefono1);
        buttonSelectImage1 = findViewById(R.id.buttonSelectImage1);
        imageButton = findViewById(R.id.imageButton);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonNext1 = findViewById(R.id.buttonNext1);


        // Configurar OnClickListener para botones de imágenes
        View.OnClickListener imageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        };

        buttonSelectImage1.setOnClickListener(imageClickListener);
        imageButton.setOnClickListener(imageClickListener);
        imageButton4.setOnClickListener(imageClickListener);
        imageButton5.setOnClickListener(imageClickListener);

        // Configurar OnClickListener para botón Siguiente
        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí guardas los datos o realizas acciones antes de navegar a ActivityLogin
                Toast.makeText(DocPaseador.this, "Felicitaciones, Registro Guardado con Exito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DocPaseador.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finaliza esta actividad para prevenir volver atrás con el botón de dispositivo
            }
        });

        // Configurar OnClickListener para botón Atrás
        buttonBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a RegistroMascotas.java
                finish(); // Finaliza esta actividad para prevenir volver atrás con el botón de dispositivo
            }
        });

        // Configurar TextWatcher para habilitar botón Siguiente al escribir en EditText
        editTelefono1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buttonNext1.setEnabled(editTelefono1.getText().toString().isEmpty());
                buttonNext1.setText(buttonNext1.isEnabled() ? "Siguiente" : "Guardar");
            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonNext1.setEnabled(s.toString().trim().length() > 0);

            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            // Aquí puedes manejar la imagen seleccionada, por ejemplo, mostrarla en un ImageView o guardarla
            Toast.makeText(this, "Imagen seleccionada: " + imageUri.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
