package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BrowserActivity extends AppCompatActivity {

    EditText browserLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        browserLink = findViewById(R.id.url_link);
        Button browserCall = findViewById(R.id.btn_browser);
        browserCall.setOnClickListener(v -> openBrowser());
    }

    public void openBrowser(){
        String link = browserLink.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW); // создан не с котекстом и классом, а с действием и поместили туда данные
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }
}