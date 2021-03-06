package com.example.labone;

import android.os.Bundle;
import android.content.DialogInterface;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    SharedPreferences prefs;
    private int color;

    private EditText Num1;
    private EditText Num2;
    private TextView result;

    public AddFragment() {
    }

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        Num1 = view.findViewById(R.id.num1_editText);
        Num2 =  view.findViewById(R.id.num2_editText);
        result = view.findViewById(R.id.result_text_add);
        
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());// регистр выбора слушает
        prefs.registerOnSharedPreferenceChangeListener(this);
        setColor(); //XML больше не подключается

        Button addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(this);
        return view;
    }
    
     private void setColor() {
        String colorName = prefs.getString(getString(R.string.pref_color_key), "Green");
        switch (colorName) {
            case "Blue":
                color = Color.BLUE;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Red":
                color = Color.RED;
                break;
            default:
                break;
        }
        Num1.setTextColor(color);
        Num2.setTextColor(color);
        result.setTextColor(color);

    }
    
    @Override
    public void onClick(View v) {
        Integer x = Integer.parseInt(Num1.getText().toString());
        Integer y = Integer.parseInt(Num2.getText().toString());
        result.setText(String.valueOf(x+y));
        addHistoryItem(x, y, x+y, "Сложение"); //занесение соответствующей записи в историю
    }

    private void addHistoryItem(int operand1, int operand2, int result, String function){

        String operand1String = String.format("%1d",operand1);
        String operand2String = String.format("%1d",operand2);
        String resultString = String.format("%1d",result);
        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryItem(operand1String, operand2String, function, resultString));
    }
    
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(getString(R.string.pref_color_key))) {
            setColor();
        }
    }
}
