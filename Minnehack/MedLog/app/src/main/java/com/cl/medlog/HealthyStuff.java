package com.cl.medlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.cl.medlog.MainActivity.KEY_MESSAGE;

public class HealthyStuff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_stuff);

        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_healthy_stuff);
        layout.addView(textView);
    }
}
