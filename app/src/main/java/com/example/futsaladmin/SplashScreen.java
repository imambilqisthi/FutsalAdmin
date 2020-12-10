package com.example.futsaladmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static int time= 5000;
    Animation down, top;
    ImageView ImgSplash;
    TextView TxtSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        down = AnimationUtils.loadAnimation(this,R.anim.down_anim);
        top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        ImgSplash = findViewById(R.id.imgSplash);
        TxtSplash = findViewById(R.id.TextSplash);
        TxtSplash.setAnimation(top);
        ImgSplash.setAnimation(down);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },time);
    }
}