package com.example.walkee;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroMascota extends Activity {

    private EditText editNombreMascota, editFechaNac, editNumRegistro, editNumChip, editDescripcion;
    private Spinner spinnerRazas, spinnerRoles;
    private ImageButton buttonSelectImage;
    private Button buttonBack, buttonNext;
    private TextView textViewTitle;
    private DatePickerDialog datePickerDialog;

    private String[] razasArray;
    private String[] tiposPerrosArray;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascotas);

        // Vincular elementos de UI
        textViewTitle = findViewById(R.id.textViewTitle);
        editNombreMascota = findViewById(R.id.editNombreMascota);
        editFechaNac = findViewById(R.id.editFechaNac);
        editNumRegistro = findViewById(R.id.editNumRegistro);
        editNumChip = findViewById(R.id.editNumChip);
        editDescripcion = findViewById(R.id.editDescripcion);
        spinnerRazas = findViewById(R.id.spinnerRazas);
        spinnerRoles = findViewById(R.id.spinnerRoles);
        buttonSelectImage = findViewById(R.id.buttonSelectImage);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        // Cargar arrays de datos
        razasArray = getResources().getStringArray(R.array.Razas);
        tiposPerrosArray = getResources().getStringArray(R.array.Tipos_Perros);

        // Configurar spinner de razas
        ArrayAdapter<String> razasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, razasArray);
        razasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRazas.setAdapter(razasAdapter);

        // Configurar spinner de tipos de perros
        ArrayAdapter<String> tiposPerrosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposPerrosArray);
        tiposPerrosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoles.setAdapter(tiposPerrosAdapter);

        // Listener para validar cambios en EditText
        editNombreMascota.addTextChangedListener(textWatcher);
        editFechaNac.addTextChangedListener(textWatcher);
        editNumRegistro.addTextChangedListener(textWatcher);
        editNumChip.addTextChangedListener(textWatcher);
        editDescripcion.addTextChangedListener(textWatcher);
        editFechaNac.setOnClickListener(v -> showDatePicker());
        editFechaNac.setFocusable(false);

        // Listener para seleccionar imagen
        buttonSelectImage.setOnClickListener(v -> selectImage());

        // Listener para botón de siguiente/guardar
        buttonNext.setOnClickListener(v -> {
            // Aquí realizas el guardado de los datos si es necesario

            // Mostrar Toast
            Toast.makeText(RegistroMascota.this, "Felicitaciones, Registro Guardado con Éxito", Toast.LENGTH_SHORT).show();

            // Abrir LoginActivity
            Intent intent = new Intent(RegistroMascota.this, LoginActivity.class);
            startActivity(intent);
        });

        // Listener para botón de atrás
        buttonBack.setOnClickListener(v -> finish());
    }

    // TextWatcher para habilitar botón de siguiente al editar campos
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            buttonNext.setEnabled(!editNombreMascota.getText().toString().isEmpty() ||
                    !editFechaNac.getText().toString().isEmpty() ||
                    !editNumRegistro.getText().toString().isEmpty() ||
                    !editNumChip.getText().toString().isEmpty() ||
                    !editDescripcion.getText().toString().isEmpty());
            buttonNext.setText(buttonNext.isEnabled() ? "Siguiente" : "Guardar");
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    // Método para mostrar el selector de fecha
    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(RegistroMascota.this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String fechaSeleccionada = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                    editFechaNac.setText(fechaSeleccionada);
                }, year, month, day);
        datePickerDialog.show();
    }

    // Método para seleccionar una imagen desde el dispositivo
    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), PICK_IMAGE);
    }
}
