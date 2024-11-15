package com.lazaro.contatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContatoDao {
    private final AppDatabase appDatabase;

    public ContatoDao(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public void salvarContato(Contato contato) {
        try (SQLiteDatabase db = appDatabase.getWritableDatabase()) {
            db.beginTransaction();
            try {
                ContentValues values = new ContentValues();
                values.put("ID", contato.getId());
                values.put("NOME", contato.getNome());
                values.put("TELEFONE", contato.getTelefone());
                values.put("EMAIL", contato.getEmail());

                db.insert("TB_CONTATO", null, values);
                db.setTransactionSuccessful();
            } catch (SQLiteException e) {
                Log.i("Erro ", "salvar contato " + e.getMessage());
            } finally {
                db.endTransaction();
            }
        }
    }

    public void alterarContato(Contato contato) {
        try (SQLiteDatabase db = appDatabase.getWritableDatabase()) {
            db.beginTransaction();
            try {
                ContentValues values = new ContentValues();
                values.put("ID", contato.getId());
                values.put("NOME", contato.getNome());
                values.put("TELEFONE", contato.getTelefone());
                values.put("EMAIL", contato.getEmail());

                db.update("TB_CONTATO", values, "ID = ?", new String[]{String.valueOf(contato.getId())});
                db.setTransactionSuccessful();
            } catch (SQLiteException e) {
                Log.i("Erro ", "alterar contato " + e.getMessage());
            } finally {
                db.endTransaction();
            }
        }
    }

    public Contato getContato(Integer id) {
        Contato contato = null;
        try (SQLiteDatabase db = appDatabase.getWritableDatabase();
             Cursor cursor = db.query("TB_CONTATO", null, "ID = ?", new String[]{String.valueOf(id)}, null, null, null)) {
            db.beginTransaction();
            try {
                if (cursor.moveToFirst()) {
                    contato = new Contato();
                    contato.setId(cursor.getInt(cursor.getColumnIndexOrThrow("ID")));
                    contato.setNome(cursor.getString(cursor.getColumnIndexOrThrow("NOME")));
                    contato.setTelefone(cursor.getString(cursor.getColumnIndexOrThrow("TELEFONE")));
                    contato.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")));
                }
                db.setTransactionSuccessful();
            } catch (SQLiteException e) {
                Log.i("Erro ", "getContato " + e.getMessage());
            } finally {
                db.endTransaction();
            }
        }
        return contato;
    }

    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
        try (SQLiteDatabase db = appDatabase.getReadableDatabase();
             Cursor cursor = db.query("TB_CONTATO", null, null, null, null, null, "NOME ASC")) {
            db.beginTransaction();
            try {
                while (cursor.moveToNext()) {
                    Contato contato = new Contato();
                    contato.setId(cursor.getInt(cursor.getColumnIndexOrThrow("ID")));
                    contato.setNome(cursor.getString(cursor.getColumnIndexOrThrow("NOME")));
                    contato.setTelefone(cursor.getString(cursor.getColumnIndexOrThrow("TELEFONE")));
                    contato.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")));
                    contatos.add(contato);
                }
                db.setTransactionSuccessful();
            } catch (SQLiteException e) {
                Log.i("Erro ", "listarContatos " + e.getMessage());
            } finally {
                db.endTransaction();
            }
        }
        return contatos;
    }
}

