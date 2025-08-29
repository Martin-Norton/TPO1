package com.tec.tpo1_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            boolean modoAvionOn = intent.getBooleanExtra("state", false);

            if (modoAvionOn) {
                Toast.makeText(context, "Modo Avión ACTIVADO", Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2664553747"));
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            } else {
                Toast.makeText(context, "Modo Avión DESACTIVADO", Toast.LENGTH_LONG).show();
            }
    }
}
