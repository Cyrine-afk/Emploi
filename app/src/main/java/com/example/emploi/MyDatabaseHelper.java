package com.example.emploi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "UnivEnLigne.db";
    private static final int DATABASE_VERSION = 1;

    /*private static final String TABLE_NAME = "meeting";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "meet_title";
    private static final String COLUMN_OWNER = "meet_owner";
    private static final String COLUMN_LINK = "meet_link";
    private static final String COLUMN_DATE = "meet_date";
    private static final String COLUMN_TIME = "meet_time";*/

    // Meeting table
    private static final String CREATE_MEETING_TABLE = "CREATE TABLE Meeting (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "meet_title TEXT," +
            "meet_duree INTEGER," +
            "meet_link TEXT," +
            "meet_date TEXT," +
            "meet_time TEXT," +
            "meet_salle TEXT" +
            ");";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MyDatabaseHelper", "Database created successfully");
        // Create your tables here
        db.execSQL(CREATE_MEETING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Meeting");

        onCreate(db);
    }
}
