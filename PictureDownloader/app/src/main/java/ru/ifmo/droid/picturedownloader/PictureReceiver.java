package ru.ifmo.droid.picturedownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ru.ifmo.droid.picturedownloader.loader.PictureLoaderService;

/**
 * Created by Appolinariya on 30.11.16.
 */

public class PictureReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PictureLoaderService.class).putExtra("base_url", PictureActivity.BASE_URL));
    }
}
