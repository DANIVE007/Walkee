package com.example.walkee;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistroPaseador extends AppCompatActivity {

    private EditText editNombres, editApellidos, editFechaNac,
            editRut, editEmail, editTelefono, editContraseña, editReContraseña, editDireccion;

    private Button buttonNext;
    private Button buttonBack;
    private ImageButton buttonSelectImage;
    private Spinner spinnerGenero;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paseador);

        editNombres = findViewById(R.id.editNombres1);
        editApellidos = findViewById(R.id.editApellidos1);
        editDireccion = findViewById(R.id.editDireccion1);
        editFechaNac = findViewById(R.id.editFechaNac1);
        editRut = findViewById(R.id.editRut1);
        editEmail = findViewById(R.id.editEmail1);
        editTelefono = findViewById(R.id.editTelefono1);
        editContraseña = findViewById(R.id.editContraseña1);
        editReContraseña = findViewById(R.id.editReContraseña1);

        buttonNext = findViewById(R.id.buttonNext1);
        buttonBack = findViewById(R.id.buttonBack1);

        buttonSelectImage = findViewById(R.id.buttonSelectImage1);

        // TextWatcher to enable/disable the Next button
        editNombres.addTextChangedListener(textWatcher);
        editApellidos.addTextChangedListener(textWatcher);
        editDireccion.addTextChangedListener(textWatcher);
        editFechaNac.addTextChangedListener(textWatcher);
        editRut.addTextChangedListener(textWatcher);
        editEmail.addTextChangedListener(textWatcher);
        editTelefono.addTextChangedListener(textWatcher);
        editContraseña.addTextChangedListener(textWatcher);
        editReContraseña.addTextChangedListener(textWatcher);
        spinnerGenero = findViewById(R.id.spinnerGenero3);

        // Configurar Spinner con el array Genero
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Genero, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapter);

        // Button to select image - Placeholder for your image selection logic

        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), PICK_IMAGE);
            }
        });


        // Button to navigate to the next step
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroPaseador.this, DocPaseador.class);
                startActivity(intent);
            }
        });
        // Button to navigate to the next step
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroPaseador.this, ElijaUsuario.class);
                startActivity(intent);
                finish();
            }

        });

        // Date picker dialog setup
        editFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    // TextWatcher to enable/disable Next button based on input fields
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            validateInputFields();
        }
    };

    // Method to enable/disable Next button based on input validation
    private void validateInputFields() {
        boolean isValid = !editNombres.getText().toString().isEmpty()
                || !editApellidos.getText().toString().isEmpty()
                || !editDireccion.getText().toString().isEmpty()
                || !editFechaNac.getText().toString().isEmpty()
                || !editRut.getText().toString().isEmpty()
                || !editEmail.getText().toString().isEmpty()
                || !editTelefono.getText().toString().isEmpty()
                || !editContraseña.getText().toString().isEmpty()
                || !editReContraseña.toString().isEmpty();

        buttonNext.setEnabled(isValid);
    }

    // Method to show date picker dialog
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Update edit text with selected date
                        editFechaNac.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}
