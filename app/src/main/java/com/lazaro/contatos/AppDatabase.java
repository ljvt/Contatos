package com.lazaro.contatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class AppDatabase extends SQLiteOpenHelper {
    private static AppDatabase INSTANCIA;
    private final static String DATABASE = "APP_CONTATOS.DB";
    private final static Integer VERSION  = 1;

    public AppDatabase(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    public static synchronized AppDatabase getInstancia(Context context) {
        if (INSTANCIA == null) {
            INSTANCIA = new AppDatabase(context);
        }
        return INSTANCIA;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_contatos(id integer primary key autoincrement, name text, telefone text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_contatos");
    }
}
