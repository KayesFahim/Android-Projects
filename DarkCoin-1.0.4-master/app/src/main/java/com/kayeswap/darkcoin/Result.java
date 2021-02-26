package com.kayeswap.darkcoin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.rewarded.RewardedAd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.darkcoin.gamelevel.Level_1;
import com.kayeswap.darkcoin.resultview.RewardVideoActivity;

public class Result extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        MobileAds.initialize(this, "ca-app-pub-7314980641738466~7023617669");


        AdView adView;
        AdView mAdView = findViewById(R.id.resultad1);
        adView = findViewById(R.id.resultad2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        adView.loadAd(adRequest);

        final Button button = findViewById(R.id.claim);
        Button playagainbtn = findViewById(R.id.playagain);
        Button bcpf = findViewById(R.id.backtopf);
        Button rewardvideo = findViewById(R.id.reward);
        rewardvideo.setVisibility(View.INVISIBLE);



        playagainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, Level_1.class));
                Result.this.finish();
            }
        });




        bcpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, ProfileActivity.class));
                Result.this.finish();
            }
        });


        FirebaseUser muser = FirebaseAuth.getInstance().getCurrentUser();

        progressDialog = new ProgressDialog(Result.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User").child(muser.getUid());

        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                UserModel user = dataSnapshot.getValue(UserModel.class);

                TextView currentcoin = findViewById(R.id.currentcoin);
                TextView name = findViewById(R.id.name);

                name.setText(user.getUserName());

                currentcoin.setText(user.getUserCoin());
                addcoin(Integer.valueOf(user.getUserCoin()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(Result.this, "Couldn't get data.", Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addValueEventListener(postListener);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int coin = result;
                    mDatabase.child("userCoin").setValue("" + coin);
                    button.setVisibility(View.GONE);
            }
        });


    }


    private void addcoin(int coins) {
        int reward = 10;
        result = coins + reward;
    }
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }


}
