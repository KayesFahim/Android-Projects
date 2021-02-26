package com.kayeswap.shahajjo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.kayeswap.shahajjo.Services.Ambulance.Ambulence;
import com.kayeswap.shahajjo.Services.Blood_Bank;
import com.kayeswap.shahajjo.Services.Covid19Activity;
import com.kayeswap.shahajjo.Services.Hospital.Hospital;

public class ServicesActivity extends AppCompatActivity {
    Button bloodbank,hospital,ambulence, covid19help;

    private AdView AdBottom;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        AudienceNetworkAds.initialize(this);

        bloodbank = findViewById(R.id.bloodbank);
        hospital = findViewById(R.id.hospital);
        ambulence = findViewById(R.id.ambulance);
        covid19help = findViewById(R.id.covid19help);



        AdBottom = new AdView(this, "411791509231092_860168327726739", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =  findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(AdBottom);

        // Request an ad
        AdBottom.loadAd();

        mInterstitialAd = new InterstitialAd(this, "411791509231092_701545956922311");
        mInterstitialAd.loadAd();




        covid19help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(ServicesActivity.this, Covid19Activity.class));

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
                        startActivity(new Intent(ServicesActivity.this, Covid19Activity.class));

                    }

                });
            }
        });



        bloodbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(ServicesActivity.this, Blood_Bank.class));

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
                        startActivity(new Intent(ServicesActivity.this, Blood_Bank.class));

                    }

                });
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(ServicesActivity.this, Hospital.class));

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
                        startActivity(new Intent(ServicesActivity.this,  Hospital.class));

                    }

                });
            }
        });

        ambulence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isAdLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(ServicesActivity.this, Ambulence.class));

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
                        startActivity(new Intent(ServicesActivity.this, Ambulence.class));

                    }

                });
            }
        });

    }


}
