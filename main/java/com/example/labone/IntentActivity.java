package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button btnTime = findViewById(R.id.button_time);
        Button btnDate = findViewById(R.id.button_date);
        btnTime.setOnClickListener(v -> Timeintent());
        btnDate.setOnClickListener(v -> Dateintent());
    }

    public void Timeintent()  {
        Intent intent = new Intent("ru.startandroid.intent.action.showtime");
        startActivity(intent);
    }

    public void Dateintent()  {
        Intent intent = new Intent("ru.startandroid.intent.action.showdate");
        startActivity(intent);
    }
}