package com.example.assg;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.editUsername);
        EditText password = findViewById(R.id.editPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(v -> {
            // Validate credentials
            if (validateCredentials(username.getText().toString(), password.getText().toString())) {
                startActivity(new Intent(this, ReportActivity.class));
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        // Logic to validate the user credentials
        return true; // Return true if valid
    }
}

