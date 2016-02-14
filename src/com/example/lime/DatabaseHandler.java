package com.example.lime;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



class DatabaseHandler extends SQLiteOpenHelper {
  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = "rushHour";
  private static final String TABLE_TODO = "todo";

  public DatabaseHandler(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_TODO_TABLE = "CREATE TABLE " + TABLE_TODO + "("
                + "id" + " INTEGER AUTO_INCREMENT PRIMARY KEY," + "name" + " TEXT,"
                + "done" + " BOOLEAN" + ")";
    db.execSQL(CREATE_CONTACTS_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);

    onCreate(db);
  }

}
