package com.example.walkee;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private ListView chatListView;
    private EditText messageEditText;
    private Button sendButton, BackButtom;
    private ChatAdapter chatAdapter;
    private ArrayList<String> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatListView = findViewById(R.id.chatListView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        BackButtom = findViewById(R.id.buttonBack2);

        messages = new ArrayList<>();
        chatAdapter = new ChatAdapter(this, messages);
        chatListView.setAdapter(chatAdapter);

        BackButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement back button functionality here
                onBackPressed();
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                if (!message.isEmpty()) {
                    messages.add("Tú: " + message);
                    chatAdapter.notifyDataSetChanged();
                    messageEditText.setText("");
                    obtenerRespuestaBot(message);
                }
            }
        });
    }

    private void obtenerRespuestaBot(String message) {
        // Placeholder para la respuesta del chatbot
        // Integra Dialogflow o cualquier otro servicio de IA aquí
        String botResponse = "Bot: " + generarRespuestaMock(message);
        messages.add(botResponse);
        chatAdapter.notifyDataSetChanged();
    }

    private String generarRespuestaMock(String message) {
        // Lógica de respuesta mock, reemplazar con la llamada real a la API de Dialogflow u otro servicio
        if (message.contains("hola")) {
            return "¡Hola! Soy Walkee ¿Cómo puedo ayudarte hoy?";
        } else if (message.contains("adiós")) {
            return "¡Adiós! Que tengas un buen día.";
        } else if (message.contains("problema")) {
            return "Entiendo el problema, Me comunicaré de Inmediato con mi Jefe para dar una solución..";
        } else if (message.contains("perrita")) {
            return "Entiendo el problema, Me comunicaré de Inmediato con mi Jefe para dar una solución..";
        } else {
            return "Disculpe las molestias estoy solucionando el problema, dejeme su N° de telefono para llamarlo devuelta";
        }
    }
}
