package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mLoginButton;
    private TextView signupText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        

        mAuth = FirebaseAuth.getInstance();
        signupText=findViewById(R.id.LoginText);

        mEmailField = findViewById(R.id.username);
        mPasswordField = findViewById(R.id.password);
        mLoginButton = findViewById(R.id.loginButton);


        signupText.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signin.class));
                finish();
            }
        }));

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailField.getText().toString().trim();
                String password = mPasswordField.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmailField.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPasswordField.setError("Password is required");
                    return;
                }

                // Sign in with email and password
                signInWithEmailAndPassword(email, password);
            }
        });
    }

    private void signInWithEmailAndPassword(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            Log.d("LoginActivity", "signInWithEmail:success");
                            Toast.makeText(login.this, "Login successful.",
                                    Toast.LENGTH_SHORT).show();
                            // Redirect to another activity after successful login
                            startActivity(new Intent(login.this, MainActivity.class));
                            finish(); // Finish this login activity
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LoginActivity", "signInWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }});}
}
