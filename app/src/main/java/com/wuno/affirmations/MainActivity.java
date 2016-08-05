package com.wuno.affirmations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarmButton = (Button)findViewById(R.id.setAlarmBtn);
        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addAffirmation();
            }
        });
    }

    public void addAffirmation() {
        TimePicker timePicker = (TimePicker) findViewById(R.id.setTimePicker);
        int hours = timePicker.getCurrentHour();
        int minutes = timePicker.getCurrentMinute();
        Long hoursMillis = TimeUnit.HOURS.toMillis(hours);
        Long minutesMillis = TimeUnit.MINUTES.toMillis(minutes);

        Long affirmationTimeMillis = hoursMillis + minutesMillis;

        Log.d("affirmationTime", String.valueOf(affirmationTimeMillis));
        AlarmReceiver alarmReceiver = new AlarmReceiver();
        alarmReceiver.setAlarm(this, affirmationTimeMillis);
    }
}


