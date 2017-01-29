package com.cl.medlog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etLog;
    AppCompatButton btnSend;
    TextView tvSelectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get today's date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        etLog = (EditText) findViewById(R.id.et_log);
        tvSelectedDate = (TextView) findViewById(R.id.tv_date);
        tvSelectedDate.setText((month+1) + "/" + day + "/" + year);
    }

    public void sendMessage(View view) {
        String message = etLog.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "DoctorMHack@gmail.com", null));
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
