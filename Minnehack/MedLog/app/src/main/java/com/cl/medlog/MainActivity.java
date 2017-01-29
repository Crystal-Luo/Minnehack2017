package com.cl.medlog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etLog;
    TextView tvSelectedDate;
    SQLiteDatabase logHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //History database
        logHistory = openOrCreateDatabase("history", MODE_PRIVATE, null);
        //Get today's date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        etLog = (EditText) findViewById(R.id.et_log);
        tvSelectedDate = (TextView) findViewById(R.id.tv_date);
        tvSelectedDate.setText((month+1) + "/" + day + "/" + year);
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
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                return true;

            case R.id.action_history:
                Intent history = new Intent(this, HistoryActivity.class);
                startActivity(history);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void sendMessage(View view) {
        //TODO: Save message to log
        logHistory.execSQL("CREATE TABLE IF NOT EXISTS Messages(Date VARCHAR, Message VARCHAR");
        logHistory.execSQL("INSERT INTO Messages(");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String email = prefs.getString("doc_email", null);
        String message = etLog.getText().toString();

        logHistory.execSQL("CREATE TABLE IF NOT EXISTS Messages(Date VARCHAR, Message VARCHAR");
        logHistory.execSQL("INSERT INTO Messages('" + tvSelectedDate.getText() + "'), '" + message + "');");

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, tvSelectedDate.getText()+" Log");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void openDatePicker(View view) {
        DatePickerFragment picker = new DatePickerFragment();
        picker.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            ((TextView) getActivity().findViewById(R.id.tv_date)).setText((month+1) + "/" + day + "/" + year);
        }
    }
}
