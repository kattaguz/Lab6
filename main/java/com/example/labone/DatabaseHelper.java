package com.example.labone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Название таблицы
    public static final String TABLE_NAME = "history";

    // Колонки таблицы
    public static final String _ID = "_id";
    public static final String OPERAND1 = "operand1";
    public static final String OPERAND2 = "operand2";
    public static final String FUNCTION = "function";
    public static final String RESULT = "result";

    // Информация о БД
    static final String DB_NAME = "history_labone.DB";

    // Версия БД
    static final int DB_VERSION = 1;

    // Создание запроса
    private static final String CREATE_TABLE = "Create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + OPERAND1 + " TEXT NOT NULL, "
            + OPERAND2 + " TEXT NOT NULL, "
            + FUNCTION + " TEXT NOT NULL, "
            + RESULT + " TEXT NOT NULL"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //onCreate - метод, который будет вызван, если БД, к которой мы хотим подключиться – не существует
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    //onUpgrade - будет вызван в случае, если мы пытаемся подключиться к БД более новой версии, чем существующая
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
