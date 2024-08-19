package com.equipo3.productosview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.equipo3.productosview.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText resetEmailEditText;
    private Button resetPasswordButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contra_view);

        resetEmailEditText = findViewById(R.id.resetEmailEditText);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);

        mAuth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String email = resetEmailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(ForgotPasswordActivity.this, "Por favor ingresa tu correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(ForgotPasswordActivity.this, "Correo de restablecimiento enviado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "Error al enviar el correo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
