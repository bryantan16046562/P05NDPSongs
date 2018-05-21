package com.example.a16046562.p05ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "songlists.db";
    private static final int DATABASE_VERSION = 1;
    private static final String table_song = "song";
    private static final String column_id = "_id";
    private static final String column_title = "title";
    private static final String column_singer = "singer";
    private static final String column_year = "year";
    private static final String column_stars = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE Song
        String createSongTableSql = "CREATE TABLE " + table_song + "("
                + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + column_title + " TEXT, "
                + column_singer + " TEXT, "
                + column_year + " INTEGER, "
                + column_stars + " INTEGER )";
        db.execSQL(createSongTableSql);
        Log.i("info", "created tables");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_song);
        onCreate(db);
    }

    public long insertSong(String title, String singers, int year, int stars){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_title, title);
        values.put(column_singer, singers);
        values.put(column_year, year);
        values.put(column_stars, stars);
        long result = db.insert(table_song, null, values);
        db.close();
        Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Song> getAllSongs(String keyword) {
        ArrayList<Song> songs = new ArrayList<Song>();


        String selectQuery = "SELECT " + column_id + "," + column_title + ","
                + column_singer + "," + column_year + "," + column_stars + " FROM " + table_song;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }
    public ArrayList<String> getAllSongs() {
        ArrayList<String> songs = new ArrayList<String>();

        String selectQuery = "SELECT " + column_id + "," + column_title + ","
                + column_singer + "," + column_year + "," + column_stars + " FROM " + table_song;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }

}
