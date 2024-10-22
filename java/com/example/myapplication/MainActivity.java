package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare a member variable to store the context
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        // Find the EditText and Button views
        EditText etCompanyName = findViewById(R.id.cname);
        EditText etAddress = findViewById(R.id.address);
        EditText etMobileNumber = findViewById(R.id.number);
        EditText etEmailAddress = findViewById(R.id.email);
        EditText etWebsite = findViewById(R.id.web);
        Button btnSubmit = findViewById(R.id.btn1);

        btnSubmit.setOnClickListener(v -> {
            String companyName = etCompanyName.getText().toString();
            String address = etAddress.getText().toString();
            String mobileNumber = etMobileNumber.getText().toString();
            String emailAddress = etEmailAddress.getText().toString();
            String website = etWebsite.getText().toString();



            Intent intent =new Intent(MainActivity.this, VisitingCardActivity.class);
            intent.putExtra("cname",companyName);
            intent.putExtra("caddress",address);
            intent.putExtra("cnumber",mobileNumber);
            intent.putExtra("cemail",emailAddress);
            intent.putExtra("cwebsite",website);

            startActivity(intent);

        });
    }

    private void displayVisitingCard(VisitingCard card) {



    }
}