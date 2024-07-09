package com.example.walkee;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MiWallet extends AppCompatActivity {

    private Spinner spinnerMonths;
    private BarGraph barGraph;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_wallet);

        spinnerMonths = findViewById(R.id.spinnerMonths);
        barGraph = findViewById(R.id.barGraph);
        ratingBar = findViewById(R.id.ratingBar4);

        // Set up spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.Months, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonths.setAdapter(spinnerAdapter);

        // Dummy data for demonstration (replace with actual monetary amounts)
        int[] amounts = {30000, 45000, 55000, 34000, 24000, 60000, 15000};

        // Set up bar graph
        barGraph.setBarsCount(7); // Number of bars (months)
        barGraph.setBarsColor(ContextCompat.getColor(this, R.color.green)); // Bar color

        // Add data to bar graph
        for (int i = 0; i < amounts.length; i++) {
            barGraph.setBarValue(i, amounts[i]); // Set bar value
        }

        // Spinner listener
        spinnerMonths.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // Show all months
                    barGraph.setSelectedMonth(-1); // No specific month selected
                } else {
                    // Show selected month
                    barGraph.setSelectedMonth(position - 1); // Adjust for "Todos" option
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected if needed
            }
        });

        // Touch listener for RatingBar
        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float touchPositionX = x - ratingBar.getLeft();
                    float width = ratingBar.getWidth();
                    float starsf = (touchPositionX / width) * 5.0f;
                    int stars = (int) starsf + 1;

                    String message = "Su Evaluación como Paseador es de " + stars + "/5";
                    showRatingDialog(message);
                }

                return true;
            }
        });

        // Back button listener
        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // Method to show AlertDialog with rating message
    private void showRatingDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Aceptar", (dialog, id) -> {
                    // Dismiss the dialog when "Aceptar" is clicked
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
