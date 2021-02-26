package com.kayeswap.darkcoin.resultview;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.*;
import com.kayeswap.darkcoin.R;
import com.kayeswap.darkcoin.gamelevel.Level_1;

public class ErrorPage extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView AdTop, AdBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_page);

        AdTop = findViewById(R.id.errorpagead1);
        AdBottom = findViewById(R.id.errorpagead2);

        Button tryagain = findViewById(R.id.tryagain);
        Button quitgame = findViewById(R.id.quitgame);

        MobileAds.initialize(this,"ca-app-pub-7314980641738466~7023617669");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7314980641738466/6570447240");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        AdTop.loadAd(new AdRequest.Builder().build());
        AdBottom.loadAd(new AdRequest.Builder().build());


        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    finish();

                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {

                        finish();
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }

                });
            }
        });

        quitgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {


                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {

                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }

                });
            }
        });



    }
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }
}
