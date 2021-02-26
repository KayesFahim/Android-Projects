package com.kayeswap.shahajjo.Services.BloodBank;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kayeswap.shahajjo.R;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RequestForBlood extends AppCompatActivity {

    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    EditText name, phn, address, btime, rel, blood, prob, how;
    Button add;

    private static final String CHANNEL_ID = "Shahajjo";
    private static final String CHANNEL_Name = "Shahajjo";
    private static final String CHANNEL_Desc = "Shahajjo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_req_page);
        add = findViewById(R.id.pbtnadd);

        name = findViewById(R.id.pname);
        phn = findViewById(R.id.pphone);
        blood = findViewById(R.id.pblood);
        address = findViewById(R.id.paddress);
        prob = findViewById(R.id.problem);
        rel = findViewById(R.id.prelation);
        how = findViewById(R.id.how);
        btime = findViewById(R.id.time);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_Name, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_Desc);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addRequest();
            }

        });

    }


    private void addRequest() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String date = df.format(c);


        mDatabase = FirebaseDatabase.getInstance().getReference("Blood_Request");

        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String nm = name.getText().toString().trim();
        String phone = phn.getText().toString().trim();
        String location = address.getText().toString().trim();
        String pblood = blood.getText().toString().trim();
        String relation = rel.getText().toString().trim();
        String pproblem = prob.getText().toString().trim();
        String equvalent =  how.getText().toString().trim();
        String time = btime.getText().toString().trim();


        if (!TextUtils.isEmpty(nm) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(location)
                && !TextUtils.isEmpty(pblood) && !TextUtils.isEmpty(relation) && !TextUtils.isEmpty(pproblem)) {

            BloodRequestModel model = new  BloodRequestModel(id, nm, phone, pblood, location, relation,  pproblem,  time,  equvalent);
            mDatabase.child(id).setValue(model);


            Toast.makeText(this,"Request Send", Toast.LENGTH_SHORT).show();
            PushNot(pblood);

            Intent intent = new Intent(RequestForBlood.this, Blood_Request.class);
            startActivity(intent);
            finish();
        }else{

            Toast.makeText(this, "Fill Up The All Box", Toast.LENGTH_SHORT).show();
        }
    }
   public void PushNot(String pblood){

       Intent resultIntent = new Intent(this, Blood_Request.class);

       TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
       stackBuilder.addNextIntentWithParentStack(resultIntent);

       PendingIntent resultPendingIntent =
               stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification_important_24px)
                .setContentTitle(pblood+" Blood Needed")
                .setContentText("You Can save a life donating your blood")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent );

        NotificationManagerCompat mnotificationManager = NotificationManagerCompat.from(this);
        mnotificationManager.notify(1, mbuilder.build());

    }
}


