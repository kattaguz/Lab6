package com.example.labone;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryItem implements Parcelable { //данные должны сохранятся в универсальном бандле
    private String operand1;
    private String operand2;
    private String function;
    private String result;

    public String getOperand1() {
        return operand1;
    }
    public String getOperand2() {
        return operand2;
    }
    public String getFunction() {
        return function;
    }
    public String getResult() {
        return result;
    }

    public HistoryItem(String operand1, String operand2, String function, String result){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.function = function;
        this.result = result;
    }

    public HistoryItem(String operand1, String function, String result){
        this.operand1 = operand1;
        this.operand2 = "";
        this.function = function;
        this.result = result;
    }

    public static final Creator<HistoryItem> CREATOR = new Creator<HistoryItem>() {
        @Override
        public HistoryItem createFromParcel(Parcel in) {
            return new HistoryItem(in);
        } //достать объект из пакета

        @Override
        public HistoryItem[] newArray(int size) {
            return new HistoryItem[size];
        }
    };

    public String getTextRepresentation(){  //текстовое описание текущей операции
        String textRepresentation;

        if(operand2.equals(""))
            textRepresentation = String.format("Получили %1s в результате функции %2s значение %3s",
                    result, function, operand1);
        else
            textRepresentation = String.format("Получили %1s в результате функции %2s сложив два числа: %3s и %4s",
                    result, function, operand1, operand2);
        return textRepresentation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected HistoryItem(Parcel in) { //
        operand1 = in.readString();
        operand2 = in.readString();
        function = in.readString();
        result = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { //создание пакета из объекта
        dest.writeString(operand1);
        dest.writeString(operand2);
        dest.writeString(function);
        dest.writeString(result);
    }
}
