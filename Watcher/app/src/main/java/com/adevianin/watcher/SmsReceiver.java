package com.adevianin.watcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Vibrator;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AudioManager amng = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

        if (amng.getRingerMode() != amng.RINGER_MODE_SILENT) {
            this.signalMsg(context);
        }
    }

    private void signalMsg(Context context){
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        long[] patern = new long[4];
        patern[0] = 0;
        patern[1] = 200;
        patern[2] = 100;
        patern[3] = 700;
        v.vibrate(patern, -1);
    }
}
