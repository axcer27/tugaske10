package com.example.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText namaMahasiswa;
    private TextView hasil;
    private DbMhsw dbMhsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbMhsw = new DbMhsw(this);
        namaMahasiswa = findViewById(R.id.editTextNama);
        hasil = findViewById(R.id.hasilNama);
    }
    public void masukkanke(View view) {
        String nama = namaMahasiswa.getText().toString();
        SQLiteDatabase db = dbMhsw.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbMhsw.nama_key, nama);
        long id = db.insert(DbMhsw.TABLE_MHSW, null, values);
        Log.d("DATABASE", "Id data: " + id);
    }
    public void tampilkan(View view) {
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = dbMhsw.getReadableDatabase();
        String query = "SELECT * FROM " + DbMhsw.TABLE_MHSW;
        Cursor Ax = db.rawQuery(query, null);
        while (Ax.moveToNext()) {
            data.add(Ax.getString(Ax.getColumnIndex(DbMhsw.nama_key)));
        }
        Ax.close();
        String hasil_input = hasil.getText().toString();
        for (int i = 0; i < data.size(); i++) {
            Log.d( "DATABASE", i + " " + data.get(i));
        }
        hasil.setText(hasil_input);
    }
}