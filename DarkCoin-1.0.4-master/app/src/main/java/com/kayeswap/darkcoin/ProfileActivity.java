package com.kayeswap.darkcoin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.darkcoin.gamelevel.Level_1;
import com.kayeswap.darkcoin.resultview.PaymentRequestActivity;

import java.util.logging.Level;

public class ProfileActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private TextView name,email,phone,bdtformat,usdformat,coin;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button playbtn = findViewById(R.id.playgame);
        Button logoutbtn = findViewById(R.id.logout);
        Button quitbtn = findViewById(R.id.quitgame);
        Button paybtn =findViewById(R.id.payment);


        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, Level_1.class));
                ProfileActivity.this.finish();
            }
        });

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, PaymentRequestActivity.class));
            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                ProfileActivity.this.finish();
            }
        });

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
        });


        FirebaseUser muser = FirebaseAuth.getInstance().getCurrentUser();

        progressDialog = new ProgressDialog(ProfileActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User").child(muser.getUid());

        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                UserModel user = dataSnapshot.getValue(UserModel.class);

                name = findViewById(R.id.userName);
                email = findViewById(R.id.userEmail);
                phone = findViewById(R.id.userPhone);
                coin = findViewById(R.id.userCoin);
                usdformat = findViewById(R.id.usd);
                bdtformat =findViewById(R.id.taka);



// get DAta
                name.setText(user.getUserName());
                email.setText(user.getUserEmail());
                phone.setText(user.getUserPhone());
                coin.setText(user.getUserCoin());

                //Conversion

                float convert = Float.parseFloat(user.getUserCoin());

                float bdttaka = (convert * 80) / 1000;
                float usdollar = (convert) / 1000;

                bdtformat.setText(String.valueOf(bdttaka));
                usdformat.setText(String.valueOf(usdollar));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(ProfileActivity.this, "Couldn't get data.", Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addValueEventListener(postListener);
    }

}