package com.adevianin.watcher;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    public HeadsetPlugReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            AudioManager amng = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

            int oldVolumeLevel = amng.getStreamVolume(AudioManager.STREAM_RING);
            int oldRingerMode = amng.getRingerMode();

            this.sleep();

            amng.setStreamVolume(AudioManager.STREAM_RING, oldVolumeLevel, AudioManager.FLAG_VIBRATE);
            amng.setRingerMode(oldRingerMode);
        }
    }

    private void sleep() {
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
        }
    }
}
