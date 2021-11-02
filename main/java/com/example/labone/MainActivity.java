package com.example.labone;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    FrameLayout fragmentSlot;

    private int state;
    private final int ADD_STATE = 1;
    private final int SQRT_STATE = 2;
    private ArrayList<HistoryItem> history; //контейнер содержит HistoryItem под названием History
    //к нему обращается фрагмент

    public static final String HISTORY_KEY = "history";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = new ArrayList<>();

        fragmentSlot = findViewById(R.id.fragment_slot);
        Button switchButton = findViewById(R.id.switch_fragment_button);

        if(fragmentSlot!=null){
            setAddFragment();
            switchButton.setOnClickListener(v -> switchFragment());
        }

    }

    public void addToHistory(HistoryItem newItem){
        history.add(newItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(HISTORY_KEY,history);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey(HISTORY_KEY))
            history = savedInstanceState.getParcelableArrayList(HISTORY_KEY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.open_history:
                Intent intent = new Intent(this, HistoryListActivity.class); //указываем какую активность открывать
                intent.putParcelableArrayListExtra(HISTORY_KEY,history);//передача данных(напрямую, без базы данных)
                //с помощью функции putParcelableArrayListExtra можно передавать листы, состоящие из Parcelable данных
                // Parcela -упаковеа поссылка, Parcelable - интерфейс, которому соответствует наш тип данных
                //мы не передаем массив из хистеров и итемов, мы передаем массив из вещей где они упаковались
                startActivity(intent);//запускаем
                break;
            case R.id.open_service:
                intent = new Intent(this, PlaySongService.class); //указываем какую активность открывать
                startActivity(intent);
                break;
            case R.id.open_browser:
                intent = new Intent(this, BrowserActivity.class); //указываем какую активность открывать
                startActivity(intent);
                break;
            case R.id.open_intent:
                intent = new Intent(this, IntentActivity.class); //указываем какую активность открывать
                startActivity(intent);
                break;
            case R.id.open_db:
                intent = new Intent(this, DBActivity.class); //указываем какую активность открывать
                startActivity(intent);
                break;
            case R.id.open_SharedPreference:
                intent = new Intent(this, SharedPreferencesActivity.class); //указываем какую активность открывать
                startActivity(intent);
                break;
            case R.id.open_file:
                intent = new Intent(this, FileActivity.class); //указываем какую активность открывать
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }

    private void setAddFragment() {
        setFragment(AddFragment.newInstance());
        state = ADD_STATE;
    }

    private void setSqrtFragment() {
        setFragment(SqrtFragment.newInstance());
        state = SQRT_STATE;
    }

    private void switchFragment() {
        if(state == ADD_STATE){
            setSqrtFragment();
        } else if (state == SQRT_STATE) {
            setAddFragment();
        }
    }

}