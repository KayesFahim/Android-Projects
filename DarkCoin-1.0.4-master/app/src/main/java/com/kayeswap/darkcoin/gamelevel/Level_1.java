package com.kayeswap.darkcoin.gamelevel;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;

import com.facebook.ads.InterstitialAdListener;

import com.kayeswap.darkcoin.R;
import com.kayeswap.darkcoin.resultview.ErrorPage;


public class Level_1 extends AppCompatActivity {
    private AdView AdBottom;
    private Button Ans;
    private Button ans1;
    private Button ans2;
    private Button ans3;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);
        AudienceNetworkAds.initialize(this);


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



        AdBottom = new AdView(this, "1183057518551866_1364335443757405", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =  findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(AdBottom);

        // Request an ad
        AdBottom.loadAd();

        mInterstitialAd = new InterstitialAd(this, "1183057518551866_1364337033757246");
        mInterstitialAd.loadAd();




        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(Level_1.this, ErrorPage.class));
                    Level_1.this.finish();

                }
                mInterstitialAd.setAdListener(new InterstitialAdListener(){
                    @Override
                    public void onError(Ad ad, AdError adError) {

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {

                    }


                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        mInterstitialAd.loadAd();
                        startActivity(new Intent(Level_1.this, ErrorPage.class));
                        Level_1.this.finish();

                    }

                });
            }
        });



        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(Level_1.this, ErrorPage.class));
                    Level_1.this.finish();

                }
                mInterstitialAd.setAdListener(new InterstitialAdListener(){
                    @Override
                    public void onError(Ad ad, AdError adError) {

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {

                    }


                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        mInterstitialAd.loadAd();
                        startActivity(new Intent(Level_1.this, ErrorPage.class));
                        Level_1.this.finish();

                    }

                });
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(Level_1.this, ErrorPage.class));
                    Level_1.this.finish();

                }
                mInterstitialAd.setAdListener(new InterstitialAdListener(){
                    @Override
                    public void onError(Ad ad, AdError adError) {

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {

                    }


                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        mInterstitialAd.loadAd();
                        startActivity(new Intent(Level_1.this, ErrorPage.class));
                        Level_1.this.finish();

                    }

                });
            }
        });

        Ans.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mInterstitialAd.isAdLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            startActivity(new Intent(Level_1.this, Level_2.class));
                            Level_1.this.finish();

                        }
                        mInterstitialAd.setAdListener(new InterstitialAdListener(){
                            @Override
                            public void onError(Ad ad, AdError adError) {

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {

                            }


                            @Override
                            public void onAdClicked(Ad ad) {

                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {

                            }


                            @Override
                            public void onInterstitialDisplayed(Ad ad) {

                            }

                            @Override
                            public void onInterstitialDismissed(Ad ad) {
                                mInterstitialAd.loadAd();
                                startActivity(new Intent(Level_1.this, Level_2.class));
                                Level_1.this.finish();

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
