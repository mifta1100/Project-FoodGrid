package com.example.foodgrid.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodgrid.R;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        getSupportActionBar().hide();
    }
}