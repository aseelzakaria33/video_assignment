package com.example.videostreamassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnn1, btnn2, btnn3, btnn4;
    private String url1 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/1%20minute%20of%20nature%20_%20vegas%20pro%2013.mp4?alt=media&token=8204b986-67a7-4940-9b7a-8f947f14be2c";
    private String url2 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/Into%20The%20Nature%20-%20Cinematic%20Travel%20Video%20_%20Sony%20a6300%20(1).mp4?alt=media&token=99e28fb4-4c74-4205-a048-0104d61b09dd";
    private String url3 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/Nature%20Is%20Speaking%20%E2%80%93%20Julia%20Roberts%20is%20Mother%20Nature%20_%20Conservation%20International%20(CI).mp4?alt=media&token=f76ebb5d-fd12-40c4-afd1-3fd2b432339d";
    private String url4 ="https://firebasestorage.googleapis.com/v0/b/iugandroid2-722b4.appspot.com/o/One%20day%201%20minute%20nature%20cinematic%20video_ujjalpaul.mp4?alt=media&token=df99e84a-8bdc-4b6e-8b1b-0c6f4e960860";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnn1 = findViewById(R.id.btn1);
        btnn2.setOnClickListener(this);
        btnn2 = findViewById(R.id.btn2);
        btnn2.setOnClickListener(this);

        btnn3 = findViewById(R.id.btn3);
        btnn3.setOnClickListener(this);

        btnn4 = findViewById(R.id.btn4);
        btnn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                GoToShowVideo(url1);
                break;
            case R.id.btn2:
                GoToShowVideo(url2);
                break;
            case R.id.btn3:
                GoToShowVideo(url3);
                break;
            case R.id.btn4:
                GoToShowVideo(url4);

                break;

        }
    }

    private void GoToShowVideo(String uri) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("uri", uri);
        startActivity(intent);
    }
}