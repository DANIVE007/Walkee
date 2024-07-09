package com.example.walkee;// LoginActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin, buttonRegister;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ElijaUsuario.class));
            }

        });
    }

    private void login() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.equals("dueño@walkee.cl") && password.equals("123")) {
            startActivity(new Intent(LoginActivity.this, OwnerActivity.class));
            finish();
        } else if (email.equals("paseador@walkee.cl") && password.equals("321")) {
            startActivity(new Intent(LoginActivity.this, WalkerActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
    @SuppressWarnings("MissingSuperCall")
    @Override
    public void onBackPressed() {
        // No hacer nada al presionar el botón de retroceso
        // Esto evita que el usuario vuelva a la pantalla anterior
        moveTaskToBack(true); // Esta línea mueve la tarea a segundo plano en lugar de finalizarla
    }
}
