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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    LinearLayout layout;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        layout = (LinearLayout) findViewById(R.id.layout_history);
        rv = (RecyclerView) findViewById(R.id.rv_history);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        List<HistoryItem> list = new ArrayList<HistoryItem>();
        //Get messages from database and display them
        SQLiteDatabase logHistory = openOrCreateDatabase("history", MODE_PRIVATE, null);
        Cursor resultSet = logHistory.rawQuery("Select * from Messages", null);
        resultSet.moveToFirst();
        while (resultSet.moveToNext()) {
            String date = resultSet.getString(resultSet.getColumnIndexOrThrow("Date"));
            String message = resultSet.getString(resultSet.getColumnIndexOrThrow("Message"));
            list.add(new HistoryItem(date, message));
        }
        rv.setAdapter(new HistoryAdapter(list), R.layout.rv_card);
        //resultSet.close();
    }

    public class HistoryItem {
        String date;
        String message;

        public HistoryItem(String date, String message) {
            this.date = date;
            this.message = message;
        }

        public String getDate() {
            return date;
        }

        public String getMessage() {
            return message;
        }
    }

    public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

        private List<HistoryItem> items;
        private int itemLayout;

        public HistoryAdapter(List<HistoryItem> items, int itemLayout) {
            this.items = items;
            this.itemLayout = itemLayout;
        }

        public void add(HistoryItem item, int position) {
            items.add(position, item);
            notifyItemInserted(position);
        }

        public void remove(HistoryItem item) {
            int position = items.indexOf(item);
            items.remove(position);
            notifyItemRemoved(position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public void onBindViewHolder(HistoryViewHolder historyViewHolder, int i) {
            HistoryItem item = items.get(i);
            historyViewHolder.date.setText(item.getDate());
            historyViewHolder.message.setText(item.getMessage());
        }

        @Override
        public HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.rv_card, viewGroup, false);

            return new HistoryViewHolder(itemView);
        }

        public class HistoryViewHolder extends RecyclerView.ViewHolder {
            protected TextView date;
            protected TextView message;

            public HistoryViewHolder(View v) {
                super(v);
                date = (TextView) v.findViewById(R.id.card_date);
                message = (TextView) v.findViewById(R.id.card_message);
            }
        }
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