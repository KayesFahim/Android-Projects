package com.kayeswap.darkcoin.resultview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.kayeswap.darkcoin.R;

public class RewardVideoActivity extends AppCompatActivity implements RewardedVideoAdListener {
    private RewardedVideoAd mAd;
    private TextView textView;
    AdView adv1,adv2,adv3,adv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reawrd_video);
        MobileAds.initialize(this, "ca-app-pub-7314980641738466~7023617669");
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);


        textView = findViewById(R.id.coin);

        loadRewardedVideoAd();

        adv1 = findViewById(R.id.adview1);
        adv2 = findViewById(R.id.adview2);
        adv3 = findViewById(R.id.adview3);
        adv4 = findViewById(R.id.adview4);
        AdRequest adRequest = new AdRequest.Builder().build();
        adv1.loadAd(adRequest);
        adv2.loadAd(adRequest);
        adv3.loadAd(adRequest);
        adv4.loadAd(adRequest);


    }

    private void loadRewardedVideoAd(){
        if(!mAd.isLoaded()) {
            mAd.loadAd("ca-app-pub-7314980641738466/7416625055",new AdRequest.Builder().build());
        }
    }


    public void VideoAdStart(View view) {
        if(mAd.isLoaded()){
            mAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        if(mAd.isLoaded()){
            mAd.show();
        }

    }

    @Override
    public void onRewardedVideoAdOpened() {
        if(mAd.isLoaded()){
            mAd.show();
        }

    }

    @Override
    public void onRewardedVideoStarted() {
        if(mAd.isLoaded()){
            mAd.show();
        }

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        textView.setText("Available Coins : 15");

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    protected void onPause() {
        mAd.pause((this));
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAd.resume((this));
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAd.destroy((this));
        super.onDestroy();
    }

    @Override
    public void onRewardedVideoCompleted() {

    }
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }
}