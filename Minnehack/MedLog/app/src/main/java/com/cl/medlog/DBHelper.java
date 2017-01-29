package com.cl.medlog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*import static com.cl.medlog.HistoryContract.HistoryEntry.DATE_COLUMN;
import static com.cl.medlog.HistoryContract.HistoryEntry.MESSAGE_COLUMN;
import static com.cl.medlog.HistoryContract.HistoryEntry.TABLE_NAME;

/**
 * Created by qwert on 1/29/2017.
 */

/*
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "history";
    public static final String CREATE_DATABASE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            HistoryContract.HistoryEntry._ID + " INTEGER PRIMARY KEY, " +
            DATE_COLUMN + " TEXT, " + MESSAGE_COLUMN + " TEXT)";

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE); //TODO: MAYBE WRONG
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertItem(String date, String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE_COLUMN, date);
        contentValues.put(MESSAGE_COLUMN, message);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + TABLE_NAME + " where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME); //TODO: IS THIS RIGHT?
        return numRows;
    }
}
*/