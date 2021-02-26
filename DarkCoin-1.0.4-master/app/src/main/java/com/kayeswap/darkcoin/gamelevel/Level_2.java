package com.kayeswap.darkcoin.gamelevel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.*;
import com.kayeswap.darkcoin.R;
import com.kayeswap.darkcoin.resultview.ErrorPage;

public class Level_2 extends AppCompatActivity {

    private Button Ans, ans1, ans2, ans3;
    private InterstitialAd mInterstitialAd;
    private AdView AdBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);

        ans1 = findViewById(R.id.ans1);
        ans1.setVisibility(View.INVISIBLE);
        ans1.postDelayed(new Runnable() {
            public void run() {
                ans1.setVisibility(View.VISIBLE);
            }
        }, 3000);

        ans2 = findViewById(R.id.ans2);
        ans2.setVisibility(View.INVISIBLE);
        ans2.postDelayed(new Runnable() {
            public void run() {
                ans2.setVisibility(View.VISIBLE);
            }
        },3000);

        ans3 = findViewById(R.id.ans3);
        ans3.setVisibility(View.INVISIBLE);
        ans3.postDelayed(new Runnable() {
            public void run() {
                ans3.setVisibility(View.VISIBLE);
            }
        },3000);
        Ans = findViewById(R.id.Ans);
        Ans.setVisibility(View.INVISIBLE);
        Ans.postDelayed(new Runnable() {
            public void run() {
                Ans.setVisibility(View.VISIBLE);
            }
        },3000);

        AdBottom = findViewById(R.id.lv2ad);


        MobileAds.initialize(this,"ca-app-pub-7314980641738466~7023617669");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7314980641738466/6570447240");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        AdBottom.loadAd(new AdRequest.Builder().build());

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    startActivity(new Intent(Level_2.this, ErrorPage.class));


                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(Level_2.this, ErrorPage.class));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }

                });
            }
        });


        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    startActivity(new Intent(Level_2.this, ErrorPage.class));

                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(Level_2.this, ErrorPage.class));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }

                });
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    startActivity(new Intent(Level_2.this, ErrorPage.class));

                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(Level_2.this, ErrorPage.class));
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }

                });
            }
        });

        Ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(Level_2.this, Level_3.class));
                    Level_2.this.finish();

                }
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        startActivity(new Intent(Level_2.this, Level_3.class));
                        Level_2.this.finish();
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
