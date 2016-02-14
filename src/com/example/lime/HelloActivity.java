package com.example.lime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.widget.*;

public class HelloActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // Get access to the defined database.
        DatabaseHandler dbHandle = new DatabaseHandler(this);
        SQLiteDatabase db = dbHandle.getWritableDatabase();

        // Create values to insert into database.
        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put("name", "pencil");
        values.put("pcount", 2);

        // Now insert them into the database.
        long error = db.insert("products", "true", values);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if(error == -1) {
          TextView tw = (TextView) findViewById(R.id.display_text);
          tw.setText("Error occured");
        }
    }

    public void showMessage(View view) {
        DatabaseHandler dbHandle = new DatabaseHandler(this);
        SQLiteDatabase db = dbHandle.getWritableDatabase();
        TextView tw = (TextView) findViewById(R.id.display_text);
        String[] cols = {"id", "name"};
        Cursor c = db.query("products", null, null, null, null, null, null  );
        String productName = "";

        c.moveToFirst();
        productName = c.getString( c.getColumnIndex("name") );
        tw.setText("best");

    }
}
