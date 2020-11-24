package com.example.appsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }
    public long insertRecord(String photo, String brand, String motor, String color, String modelo, String velocidad, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_PHOTO, photo);
        values.put(Constants.C_BRAND, brand);
        values.put(Constants.C_MOTOR, motor);
        values.put(Constants.C_COLOR, color);
        values.put(Constants.C_MODELO, modelo);
        values.put(Constants.C_VELOCIDAD, velocidad);
        values.put(Constants.C_PRICE, price);

        long id = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return id;
    }
}
