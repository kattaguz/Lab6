package com.example.labone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.HistoryItemViewHolder>{

    private ArrayList<HistoryItem> history;
    HistoryListAdapter(){
        history = new ArrayList<>();
    }

    void initialize(ArrayList<HistoryItem> history){ //иницилизация массива
        this.history = history;
    }

    @NonNull
    @Override
    public HistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //создает одну новую строчку
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_list_item, viewGroup, false);
        return new HistoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryItemViewHolder historyItemViewHolder, int i) {  //привязывает к строчке данные
        historyItemViewHolder.bind(history.get(i));
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryItemViewHolder extends RecyclerView.ViewHolder {

        private TextView historyText;
        private Button historyButton;

        HistoryItemViewHolder(View itemView) {
            super(itemView);
            historyText = itemView.findViewById(R.id.history_text);
            historyButton = itemView.findViewById(R.id.history_button);
        }

        void bind(HistoryItem historyItem) { //привязывание объекта к строчке
            historyText.setText(historyItem.getTextRepresentation());
            historyButton.setOnClickListener(v -> Toast.makeText(historyButton.getContext(),      //обработчик
                            historyItem.getTextRepresentation(),
                            Toast.LENGTH_SHORT)
                            .show());
        }
    }
}