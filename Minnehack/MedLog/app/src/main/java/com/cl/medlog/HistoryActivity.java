package com.cl.medlog;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;


import static com.cl.medlog.HistoryContract.HistoryEntry.TABLE_NAME;

public class HistoryActivity extends AppCompatActivity {
    LinearLayout layout;
    RecyclerView rv;
    //DBHelper dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        layout = (LinearLayout) findViewById(R.id.layout_history);
        /*List<HistoryItem> list = new ArrayList<HistoryItem>();
        dbHelp = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelp.getReadableDatabase();
        String[] projection = {
                HistoryContract.HistoryEntry._ID,
                HistoryContract.HistoryEntry.DATE_COLUMN,
                HistoryContract.HistoryEntry.MESSAGE_COLUMN
        };

// Filter results WHERE "title" = 'My Title'
        String selection = "*";
        String[] selectionArgs = null;

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                HistoryContract.HistoryEntry.DATE_COLUMN + " DESC";

        Cursor cursor = db.query(
                HistoryContract.HistoryEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME, null); //TODO: WRONG?
        c.moveToFirst();
        rv = (RecyclerView) findViewById(R.id.rv_history);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        do {
            String date = c.getString(1);
            String message = c.getString(2);
            list.add(new HistoryItem(message, date));
        }while (c.moveToNext());

        c.close();
        rv.setAdapter(new HistoryAdapter(list, R.id.card_view));*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}