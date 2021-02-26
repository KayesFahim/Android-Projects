package com.kayeswap.shahajjo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Start extends AppCompatActivity {

    ImageView Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Start = findViewById(R.id.start);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Start.startAnimation(myFadeInAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("ActivityPREF",    Context.MODE_PRIVATE);
                if(pref.getBoolean("activity_executed", false)){
                    startActivity(new Intent(Start.this, Welcome.class));
                } else {
                    startActivity(new Intent(Start.this, PrivacyPolicy.class));
                    finish();
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putBoolean("activity_executed", true);
                    ed.commit();
                }
            }
        }, 3000);
    }

}
