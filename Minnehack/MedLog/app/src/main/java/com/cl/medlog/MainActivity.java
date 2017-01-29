package com.cl.medlog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.Math;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MESSAGE = "com.cl.medlog.MainActivity.KEY";
    EditText etLog;
    TextView tvSelectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
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
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void sendMessage(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String email = prefs.getString("doc_email", null);
        String message = etLog.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, tvSelectedDate.getText() + " Log");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void openDatePicker(View view) {
        DatePickerFragment picker = new DatePickerFragment();
        picker.show(getSupportFragmentManager(), "datePicker");
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    public void diagnoseSymptoms(View view)
    {
        Intent intent = new Intent(this, DiagnosticPage.class);
        startActivity(intent);
    }

    public void randomHealthyAction(View view)
    {
        Intent intent = new Intent(this, HealthyStuff.class);
        int randPaul = (int) (50.0 * Math.random());
        switch(randPaul)
        {
            case 0: intent.putExtra(KEY_MESSAGE, "Eat an orange!"); break;
            case 1: intent.putExtra(KEY_MESSAGE, "Play a game of soccer!"); break;
            case 2: intent.putExtra(KEY_MESSAGE, "Take your dog on a walk!"); break;
            case 3: intent.putExtra(KEY_MESSAGE, "Run up one hundred seven flights of stairs!"); break;
            case 4: intent.putExtra(KEY_MESSAGE, "Go bungee jumping!"); break;
            case 5: intent.putExtra(KEY_MESSAGE, "Climb Mount Everest!"); break;
            case 6: intent.putExtra(KEY_MESSAGE, "Go over Niagara Falls in a barrel!"); break;
            case 7: intent.putExtra(KEY_MESSAGE, "Crawl to China!"); break;
            case 8: intent.putExtra(KEY_MESSAGE, "Re-enact the seige of Orleans!"); break;
            case 9: intent.putExtra(KEY_MESSAGE, "Debate the merits of government redistribution of wealth!"); break;
            case 10: intent.putExtra(KEY_MESSAGE, "Play a rousing match of tennis!"); break;
            case 11: intent.putExtra(KEY_MESSAGE, "Win at Microsoft Minesweeper on the hardest setting!"); break;
            case 12: intent.putExtra(KEY_MESSAGE, "Build a giant robot with laser eyes!"); break;
            case 13: intent.putExtra(KEY_MESSAGE, "Engage in scientific research!"); break;
            case 14: intent.putExtra(KEY_MESSAGE, "Perform open heart surgery!"); break;
            case 15: intent.putExtra(KEY_MESSAGE, "Prepare a large meal of traditional Indian cuisine!"); break;
            case 16: intent.putExtra(KEY_MESSAGE, "Write your mother a letter!"); break;
            case 17: intent.putExtra(KEY_MESSAGE, "Be a superhero!"); break;
            case 18: intent.putExtra(KEY_MESSAGE, "Take the skinheads bowling!"); break;
            case 19: intent.putExtra(KEY_MESSAGE, "Go fishing for weasels in the Caribbean!"); break;
            case 20: intent.putExtra(KEY_MESSAGE, "Kill the headlights and put it in neutral!"); break;
            case 21: intent.putExtra(KEY_MESSAGE, "Dress up like a sultan in your onion head hat!"); break;
            case 22: intent.putExtra(KEY_MESSAGE, "Put Humpty Dumpty back together again!"); break;
            case 23: intent.putExtra(KEY_MESSAGE, "Free a rat from a cage!"); break;
            case 24: intent.putExtra(KEY_MESSAGE, "Dodge the draft!"); break;
            case 25: intent.putExtra(KEY_MESSAGE, "Don't kill a mockingbird!"); break;
            case 26: intent.putExtra(KEY_MESSAGE, "Prove Fermat's Last Theorem!"); break;
            case 27: intent.putExtra(KEY_MESSAGE, "Sleepwalk through your waking life and wake-walk through your dreams!"); break;
            case 28: intent.putExtra(KEY_MESSAGE, "Spend 24 hours meditating atop a flag pole!"); break;
            case 29: intent.putExtra(KEY_MESSAGE, "Play bass for the Sex Pistols!"); break;
            case 30: intent.putExtra(KEY_MESSAGE, "Take out a life insurance policy!"); break;
            case 31: intent.putExtra(KEY_MESSAGE, "Verify the Law of Universal Gravitation!"); break;
            case 32: intent.putExtra(KEY_MESSAGE, "Circumnavigate the Earth!"); break;
            case 33: intent.putExtra(KEY_MESSAGE, "Program a Lisp interpreter!"); break;
            case 34: intent.putExtra(KEY_MESSAGE, "Don't take any wooden nickels!"); break;
            case 35: intent.putExtra(KEY_MESSAGE, "Stop and smell the roses!"); break;
            case 36: intent.putExtra(KEY_MESSAGE, "Spend a year at Walden Pond!"); break;
            case 37: intent.putExtra(KEY_MESSAGE, "Bury something beneath the floorboards!"); break;
            case 38: intent.putExtra(KEY_MESSAGE, "Make an Android app!"); break;
            case 39: intent.putExtra(KEY_MESSAGE, "Expose the lunacy of the United States Constitution!"); break;
            case 40: intent.putExtra(KEY_MESSAGE, "Determine the rate of decay of a radioactive isotope!"); break;
            case 41: intent.putExtra(KEY_MESSAGE, "Cross a border!"); break;
            case 42: intent.putExtra(KEY_MESSAGE, "Ski uphill!"); break;
            case 43: intent.putExtra(KEY_MESSAGE, "Keep 'em separated!"); break;
            case 44: intent.putExtra(KEY_MESSAGE, "Don't talk about Fight Club!");
            case 45: intent.putExtra(KEY_MESSAGE, "Put on a tie!"); break;
            case 46: intent.putExtra(KEY_MESSAGE, "Make and sell soap!"); break;
            case 47: intent.putExtra(KEY_MESSAGE, "Don't act like it's not Opposite Day!"); break;
            case 48: intent.putExtra(KEY_MESSAGE, "Sleep like the woodchuck!"); break;
            case 49: intent.putExtra(KEY_MESSAGE, "Go to college to get more knowledge!"); break;
            default: intent.putExtra(KEY_MESSAGE, "Die!"); break;       //Note that the switch block will never fall through to this statement and as such it will never occur. Further note that this statement is more or less equivalent to about half of the others, perhaps more on a bad day.
        }
        startActivity(intent);
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
            ((TextView) getActivity().findViewById(R.id.tv_date)).setText((month + 1) + "/" + day + "/" + year);
        }
    }
}
