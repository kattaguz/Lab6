package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DBActivity extends AppCompatActivity {

    TextView dbContent;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        dbContent = findViewById(R.id.db_textView);
        databaseManager = new DatabaseManager(this);
        databaseManager.open();

        Button showDbButton = findViewById(R.id.show_db_button);
        showDbButton.setOnClickListener(v -> showDb());
        Button clearScreenButton = findViewById(R.id.clear_screen_button);
        clearScreenButton.setOnClickListener(v -> clearScreen());
    }
    private void showDb() {
        dbContent.setText(databaseManager.getAllAsText());
    }
    private void clearScreen() {
        dbContent.setText("");
    }
}