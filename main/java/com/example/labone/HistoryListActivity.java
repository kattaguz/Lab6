package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class HistoryListActivity extends AppCompatActivity {

    HistoryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        Intent intent = getIntent();

        adapter = new HistoryListAdapter();
        if(intent!=null && intent.hasExtra(MainActivity.HISTORY_KEY)){
            adapter.initialize(intent.getParcelableArrayListExtra(MainActivity.HISTORY_KEY)); //создаем адаптер и передаем массив
        }

        RecyclerView recyclerView = findViewById(R.id.historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //передаем в качестве адаптера тот адаптер, который создали и указываем Manadger
        //LayoutManager - описывает каким именно образом будут распалагаться элементы в списке
        recyclerView.setAdapter(adapter);
    }
}