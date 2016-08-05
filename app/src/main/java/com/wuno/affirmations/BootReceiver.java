package com.wuno.affirmations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wuno on 5/17/16.
 */
public class BootReceiver extends BroadcastReceiver {

    AlarmReceiver alarmReceiver = new AlarmReceiver();
    Long affirmationTime;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            alarmReceiver.setAlarm(context, affirmationTime);
        }
    }
}
