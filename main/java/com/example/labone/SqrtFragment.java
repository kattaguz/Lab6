package com.example.labone;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SqrtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SqrtFragment extends Fragment implements View.OnClickListener{

    private EditText x_sqrt;
    private TextView result;

    public SqrtFragment() {
        // Required empty public constructor
    }


    public static SqrtFragment newInstance() {
        return new SqrtFragment();}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqrt, container, false);

        result = view.findViewById(R.id.result_text_sqrt);
        x_sqrt = view.findViewById(R.id.x_editText);
        Button sqrtButton = view.findViewById(R.id.button_sqrt);
        sqrtButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Integer x = Integer.parseInt(x_sqrt.getText().toString());
        result.setText(String.valueOf(Math.pow(x,2)));
        sqrtHistoryItem(x, x*x , "Возвести в квадрат");

    }

    private void sqrtHistoryItem(int operand1, int result, String function){
        String operand1String = String.format("%1d",operand1);
        String resultString = String.format("%1d",result);
        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryItem(operand1String, function, resultString));
    }
}