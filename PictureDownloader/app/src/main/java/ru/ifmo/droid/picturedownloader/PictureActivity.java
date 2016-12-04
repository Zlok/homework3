package ru.ifmo.droid.picturedownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Appolinariya on 30.11.16.
 */

public class PictureActivity extends AppCompatActivity{
    private ImageView imageView;
    private TextView textView;
    private BroadcastReceiver receiver;

    public static String BASE_URL = "https://pp.vk.me/c623426/v623426777/175f9/d_vqH593qeM.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        final String fileName = "/image.jpg";

        textView = (TextView) findViewById(R.id.errorText);
        imageView = (ImageView) findViewById(R.id.image);

        textView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);


        File file = new File(getFilesDir(), fileName);
        if (file.exists()) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                File f = new File(getFilesDir(), fileName);
                imageView.setImageBitmap(BitmapFactory.decodeFile(f.getPath()));
                textView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }
        };
        registerReceiver(receiver, new IntentFilter("BROADCAST"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
