package com.example.videostreamassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class VideoActivity extends AppCompatActivity {
    private PlayerView playerView;
    SimpleExoPlayer playerV;
    private String videoUrl;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playPackPosition = 0;
    String urll1="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/1%20minute%20of%20nature%20_%20vegas%20pro%2013.mp4?alt=media&token=8204b986-67a7-4940-9b7a-8f947f14be2c";
    private String urll2 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/Into%20The%20Nature%20-%20Cinematic%20Travel%20Video%20_%20Sony%20a6300%20(1).mp4?alt=media&token=99e28fb4-4c74-4205-a048-0104d61b09dd";
    private String urll3 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/Nature%20Is%20Speaking%20%E2%80%93%20Julia%20Roberts%20is%20Mother%20Nature%20_%20Conservation%20International%20(CI).mp4?alt=media&token=f76ebb5d-fd12-40c4-afd1-3fd2b432339d";
    private String urll4 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/One%20day%201%20minute%20nature%20cinematic%20video_ujjalpaul.mp4?alt=media&token=df99e84a-8bdc-4b6e-8b1b-0c6f4e960860";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        playerView = findViewById(R.id.viedo_v);
        String re_Url = getIntent().getStringExtra("urll");

        if (re_Url.equals(urll1)) {
            videoUrl = urll1;
        } else if (re_Url.equals(urll2)) {
            videoUrl = urll2;
        } else if (re_Url.equals(urll3)){
            videoUrl = urll3;
        }else if (re_Url.equals(urll4)){
            videoUrl = urll4;
        }



    }
    private void releaseVideo() {
        if (playerV != null) {
            playWhenReady = playerV.getPlayWhenReady();
            playPackPosition = playerV.getCurrentPosition();
            currentWindow = playerV.getCurrentWindowIndex();
            playerV.release();
            playerV = null;

        }
    }

    private void initVideo() {
        playerV = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(playerV);
        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer_codelab");
        Log.e("uriiiiiiiiiiiiiiiiiiiii",videoUrl);
        Log.e("cureent",currentWindow +"");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        playerV.setPlayWhenReady(playWhenReady);
        playerV.seekTo(currentWindow, playPackPosition);
        playerV.prepare(mediaSource, false, false);

    }



    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }



    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}