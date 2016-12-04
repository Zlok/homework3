package ru.ifmo.droid.picturedownloader.loader;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Appolinariya on 30.11.16.
 */

public class PictureLoaderService extends IntentService {

    public PictureLoaderService() {
        super("PictureLoaderService");
    }

    public void onCreate() {
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent) {
        try {
            URL url = new URL(intent.getStringExtra("base_url"));
            Log.d("MyLogs", "onHandle... " + url);
            Bitmap bmp = BitmapFactory.decodeStream((InputStream)url.getContent());
            FileOutputStream fout = openFileOutput("image.jpg", Context.MODE_PRIVATE);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
