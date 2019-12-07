package com.example.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void onSettingsClick(View view) {
            Intent in=new Intent(HomePage.this, LocationActivity.class);
            startActivity(in);
    }

    public void onCameraClick(View view) {
        Intent in=new Intent(HomePage.this,CameraActivity.class);
        startActivity(in);
    }

    public void onImagesClick(View view) {
        Intent in=new Intent(HomePage.this,ImagesActivity.class);
        startActivity(in);
    }

    public void onMediaPlayerClick(View view) {
        Intent in=new Intent(HomePage.this,MediaPlayerActivity.class);
        startActivity(in);
    }

    public void onNotesClick(View view) {
        Intent in=new Intent(HomePage.this,NotesActivity.class);
        startActivity(in);
    }

    public void onVoiceRecorderClick(View view) {
        Intent in=new Intent(HomePage.this,VoiceRecorderActivity.class);
        startActivity(in);
    }

}
