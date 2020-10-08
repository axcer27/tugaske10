package com.example.mahasiswa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbMhsw extends SQLiteOpenHelper {

    private static final String database_name = "Mhsw.db";
    private static final int database_version = 1;
    public static final String TABLE_MHSW = "Mahasiswa";
    private static final String id_key = "id";
    public static final String nama_key = "nama";

    private static final String CREATE_TABLE_MHSW = "CREATE TABLE " + TABLE_MHSW + "(" +
            id_key + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            nama_key + " TEXT );";

    public DbMhsw(@Nullable Context context) {
        super(context, database_name, null
                , database_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MHSW);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MHSW);
        onCreate(db);
    }
}