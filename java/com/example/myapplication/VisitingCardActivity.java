package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kotlin.experimental.BitwiseOperationsKt;

public class VisitingCardActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private ImageView imageView;
   private Button savePhotoToGallery;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiting_card);

        Bundle b = getIntent().getExtras();

        //VisitingCard card=b.getSerializable("card", Vis)
        savePhotoToGallery = findViewById(R.id.savebtn);
        TextView tvCompanyName = findViewById(R.id.tvCompanyName);
        TextView tvAddress = findViewById(R.id.tvAddress);
        TextView tvMobileNumber = findViewById(R.id.tvMobileNumber);
        TextView tvEmailAddress = findViewById(R.id.tvEmailAddress);
        TextView tvWebsite = findViewById(R.id.tvWebsite);
//        imageView = findViewById(R.id.);


        tvCompanyName.setText("" + b.getString("cname"));
        tvAddress.setText("" + b.getString("caddress"));
        tvMobileNumber.setText("" + b.getString("cnumber"));
        tvEmailAddress.setText("" + b.getString("cemail"));
        tvWebsite.setText("" + b.getString("cwebsite"));


    }}






