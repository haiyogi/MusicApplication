package com.harman.musicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Instantiating the MediaPlayer class
    MediaPlayer music;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar= findViewById(R.id.seekBar2);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(this, R.raw.pirates);

        seekBar.setMax(music.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(music.getCurrentPosition());
            }
        },0,900);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                music.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // Playing the music
    public void musicplay(View v)
    {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(this, R.raw.pirates);
    }

}