package com.example.walkee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.example.walkee.LoginActivity;
import com.example.walkee.OwnerActivity;

public class ElijaUsuario extends AppCompatActivity {

    private Spinner spinnerRoles;
    private Button buttonBack;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoperifl);

        spinnerRoles = findViewById(R.id.spinner_roles);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoles.setAdapter(adapter);

        spinnerRoles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedRole = parent.getItemAtPosition(position).toString();

                if (!selectedRole.equals("Elija Usuario")) {
                    buttonNext.setEnabled(true);
                } else {
                    buttonNext.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                buttonNext.setEnabled(false);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElijaUsuario.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonNext.setOnClickListener(v -> {
            String selectedRole = spinnerRoles.getSelectedItem().toString();

            if (selectedRole.equals("Paseador")) {
                Intent intent = new Intent(ElijaUsuario.this, RegistroPaseador.class);
                startActivity(intent);
            } else if (selectedRole.equals("Dueño de Mascota")) {
                Intent intent = new Intent(ElijaUsuario.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
