package com.example.walkee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerminosCondicionesDueno extends AppCompatActivity {

    private TextView textViewTerms;
    private CheckBox checkBoxAgree;
    private Button buttonBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones_dueno);

        textViewTerms = findViewById(R.id.textViewTerms);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        buttonBack = findViewById(R.id.buttonBack);

        loadTermsAndConditions();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement back button functionality here
                onBackPressed();
            }
        });
    }

    private void loadTermsAndConditions() {
        InputStream inputStream = getResources().openRawResource(R.raw.terms_and_conditions);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            textViewTerms.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
