package org.enthusia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity{

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        View v = findViewById(R.id.container);
        v.startAnimation(animation);
        imageView.startAnimation(fadeIn);
        Handler handler = new Handler();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(i);
                finish();
            }
        },2500);
    }
}