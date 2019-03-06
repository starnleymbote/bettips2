package com.nanocomputing.bettips;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public  class SyncButtonListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        Toast.makeText(context,"Synch button has been clicked!!",Toast.LENGTH_LONG).show();
    }
}
