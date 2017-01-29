package com.cl.medlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiagnosticPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_page);
    }

    public void goToFever(View view)
    {
        Intent intent = new Intent(this, FeverPage.class);
        startActivity(intent);
    }

    public void goToHeadache(View view)
    {
        Intent intent = new Intent(this, HeadachePage.class);
        startActivity(intent);
    }

    public void goToEarache(View view)
    {
        Intent intent = new Intent(this, EarachePage.class);
        startActivity(intent);
    }

    public void goToBlurredVision(View view)
    {
        Intent intent = new Intent(this, BlurredVisionPage.class);
        startActivity(intent);
    }

    public void goToCancer(View view)
    {
        Intent intent = new Intent(this, CancerPage.class);
        startActivity(intent);
    }

    public void goToCough(View view)
    {
        Intent intent = new Intent(this, CoughPage.class);
        startActivity(intent);
    }

    public void goToDizziness(View view)
    {
        Intent intent = new Intent(this, DizzinessPage.class);
        startActivity(intent);
    }

    public void goToLackOfAHead(View view)
    {
        Intent intent = new Intent(this, LackOfAHeadPage.class);
        startActivity(intent);
    }

    public void goToNumbness(View view)
    {
        Intent intent = new Intent(this, NumbnessPage.class);
        startActivity(intent);
    }

    public void goToParalysis(View view)
    {
        Intent intent = new Intent(this, ParalysisPage.class);
        startActivity(intent);
    }

    public void goToRottingFlesh(View view)
    {
        Intent intent = new Intent(this, RottingFleshPage.class);
        startActivity(intent);
    }

    public void goToSoreThroat(View view)
    {
        Intent intent = new Intent(this, SoreThroatPage.class);
        startActivity(intent);
    }

    public void goToStomachache(View view)
    {
        Intent intent = new Intent(this, StomachachePage.class);
        startActivity(intent);
    }
}
