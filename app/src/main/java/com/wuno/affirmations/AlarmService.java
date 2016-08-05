package com.wuno.affirmations;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

/**
 * Created by wuno on 5/17/16.
 */
public class AlarmService extends IntentService {
    private static final int NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Logic for the background task
        // I need the notification to be created here
        // this is the logic for when my alarm is fired off
        getAffirmation();
        // this tell if the related work is complete then system tracks for another alarm.
        AlarmReceiver.completeWakefulIntent(intent);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }



    public void getAffirmation() {
        Context context = this.getApplicationContext();
        notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent mIntent = new Intent(this, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Your Affirmation Is Ready");
        builder.setContentText("get your bananas");
        builder.setSmallIcon(R.drawable.ic_action_wuno);
        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
}