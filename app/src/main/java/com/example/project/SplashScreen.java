package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    Animation animation;

    ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        splash = findViewById(R.id.ivSplash);

        splash.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindahHome = new Intent(SplashScreen.this, HomePage.class);
                pindahHome.putExtra("name", name);
                startActivity(pindahHome);
                finish();
            }
        }, SPLASH_SCREEN);


    }
}

