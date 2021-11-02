package com.example.labone;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ServiceActivity extends Service {
    private MediaPlayer mediaPlayer;
    public ServiceActivity() {
    }

    public void onCreate(){
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.skyfall);
        mediaPlayer.setLooping(false);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        String message = getResources().getString(R.string.start_mess);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        writeToFile(message);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        String message = getResources().getString(R.string.stop_mess);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        writeToFile(message);
        mediaPlayer.stop();
    }

    public IBinder onBind(Intent intent) {return null;}

    private void writeToFile(String message) {
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(downloadsDir, getString(R.string.log_file_name));
        try {
            FileWriter out = new FileWriter(myFile, true);
            out.write(message+"\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}