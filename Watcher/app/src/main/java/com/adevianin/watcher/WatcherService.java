package com.adevianin.watcher;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class WatcherService extends Service {
    public WatcherService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_myplaces).setWhen(System.currentTimeMillis())
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentTitle("Fixer");

        this.startForeground(1, builder.build());

        headsetFixer();

        Toast.makeText(this, "watcher started", Toast.LENGTH_LONG).show();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public void headsetFixer(){
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(new HeadsetPlugReceiver(), filter);
    }

}
