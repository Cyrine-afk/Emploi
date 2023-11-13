package com.example.emploi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.emploi.entities.Meeting;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "UnivEnLigne.db";
    private static final int DATABASE_VERSION = 1;

    /*private static final String TABLE_NAME = "meeting";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "meet_title";
    private static final String COLUMN_OWNER = "meet_owner";
    private static final String COLUMN_LINK = "meet_link";
    private static final String COLUMN_DATE = "meet_date";*/

    // Meeting table
    private static final String CREATE_MEETING_TABLE = "CREATE TABLE Meeting (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "meet_title TEXT," +
            "meet_duree INTEGER," +
            "meet_link TEXT," +
            "meet_date TEXT," +
            "meet_salle TEXT" +
            ");";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static synchronized MyDatabaseHelper getInstance(Context context) {
        return new MyDatabaseHelper(context.getApplicationContext());
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

    void addMeet(Meeting meeting){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //cv.put("_id", meeting.getIdMeet());
        cv.put("meet_title", meeting.getMeetTitle());
        cv.put("meet_duree", meeting.getMeetDuree());
        cv.put("meet_link", meeting.getMeetLink());
        cv.put("meet_date", meeting.getMeetDate());
        cv.put("meet_salle", meeting.getMeetSalle());

        long result = db.insert("Meeting",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }



}
