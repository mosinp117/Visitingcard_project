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

public class signin extends AppCompatActivity {


    private EditText mEmailField;
    private EditText mPasswordField;
    private Button  mRegisterButton;
    private TextView LoginText;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_signin);



        mAuth = FirebaseAuth.getInstance();
        LoginText = findViewById(R.id.LoginText);


        mEmailField = findViewById(R.id.username);
        mPasswordField = findViewById(R.id.password);
        mRegisterButton= findViewById(R.id.signinbtn);



        LoginText.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, login.class));
                finish();
            }
        }));


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
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

                // Create user with email and password

                mAuth.createUserWithEmailAndPassword(email, password);
            }
        });

    }
    private void createUserWithEmailAndPassword (String email, String password) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Registration success
                                Log.d("RegisterActivity", "createUserWithEmail:success");
                                Toast.makeText(signin.this, "Registration successful.",
                                        Toast.LENGTH_SHORT).show();
                                // After successful registration, you may redirect the user to another activity
                                startActivity(new Intent(signin.this, MainActivity.class));
                            } else {
                                // If registration fails, display a message to the user.
                                Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(signin.this, "Registration failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });}}




