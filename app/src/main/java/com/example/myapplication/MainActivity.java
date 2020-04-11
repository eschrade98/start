package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity  {

    //declares the Variables
    Button btnStartRecord, btnStopRecord, btnPlay, btnStop;
    private MediaRecorder recorder = null;
    private MediaPlayer   player = null;
    private static final String LOG_TAG = "AudioRecordTest";
    private static String fileName = null;

    final int REQUEST_PERMISSION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request Runtime permission
        if(!checkPermissionFromDevice())
            requestPermissions();

        //initial Buttons with ButtonIDs
        btnStartRecord = findViewById(R.id.btnStartRecord);
        btnStopRecord = findViewById(R.id.btnStopRecord);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        //sets only recordButton visible
        setButtonVisibility(0);

            btnStartRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkPermissionFromDevice())
                    {
                        fileName = getExternalCacheDir().getAbsolutePath();
                        fileName += "/audiorecordtest.3gp";
                        onRecord(true);
                        setButtonVisibility(1);
                        Toast.makeText(MainActivity.this, "Recording...", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        requestPermissions();
                    }
                }
            });

            btnStopRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecord(false);
                    setButtonVisibility(2);
                    Toast.makeText(MainActivity.this, "Recording stopped...", Toast.LENGTH_SHORT).show();
                }
            });

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlay(true);
                    setButtonVisibility(3);
                    Toast.makeText(MainActivity.this, "Playing...", Toast.LENGTH_SHORT).show();
                }
            });

            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlay(false);
                    setButtonVisibility(4);
                    Toast.makeText(MainActivity.this, "Playing Stopped...", Toast.LENGTH_SHORT).show();
                }
            });
    }

    /**
     * enables buttons or disables them, depending from the needed status
     *
     * @param configuration sets the configuration
     */
    private void setButtonVisibility(int configuration){
        switch (configuration){
            case 0:
                btnPlay.setEnabled(false);
                btnStop.setEnabled(false);
                btnStartRecord.setEnabled(true);
                btnStopRecord.setEnabled(false);
                break;
            case 1:
                btnPlay.setEnabled(false);
                btnStop.setEnabled(false);
                btnStartRecord.setEnabled(false);
                btnStopRecord.setEnabled(true);
                break;
            case 2:
                btnPlay.setEnabled(true);
                btnStop.setEnabled(false);
                btnStartRecord.setEnabled(true);
                btnStopRecord.setEnabled(false);
                break;
            case 3:
                btnPlay.setEnabled(false);
                btnStop.setEnabled(true);
                btnStopRecord.setEnabled(false);
                btnStartRecord.setEnabled(false);
                break;
            case 4:
                btnPlay.setEnabled(true);
                btnStop.setEnabled(false);
                btnStopRecord.setEnabled(false);
                btnStartRecord.setEnabled(true);
                break;
        }
    }

    /**
     * starts or stops the recording
     *
     * @param start when true, record is started
     */
    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    /**
     * starts or stops the playing of the record
     *
     * @param start when true, record is played
     */
    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    /**
     * starts a new instance of media player
     */
    private void startPlaying() {
        player = new MediaPlayer();
        try {
            player.setDataSource(fileName);
            player.prepare();
            player.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    /**
     * stops the media player
     */
    private void stopPlaying() {
        player.release();
        player = null;
    }

    /**
     * starts the Recording
     */
    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
        recorder.start();
    }

    /**
     * closes the recorder, so a new recording can be started
     */
    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
    }

    /**
     * ask user for permissions
     */
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        },REQUEST_PERMISSION_CODE);
    }

    @Override
    /**
     * i have no clue
     */
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_PERMISSION_CODE:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
                break;
        }
    }

    /**
     * boolean is true when storage and audio permissions are granted
     * @return true when storage and audio permissions are granted
     */
    private boolean checkPermissionFromDevice() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);

        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }
}

