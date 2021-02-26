package com.kayeswap.shahajjo.Services.Covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.CovidCautionsP.CovidCautionsAdapter;
import com.kayeswap.shahajjo.Services.Covid19.CovidCautionsP.CovidCautionsModel;

import java.util.ArrayList;

public class CovidCautions extends AppCompatActivity {
    DatabaseReference reference1,reference2,reference3,reference4;
    RecyclerView recyclerView1,recyclerView2,recyclerView3,recyclerView4;
    ArrayList<CovidCautionsModel> mlist;
    CovidCautionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_cautions);

        recyclerView1 = findViewById(R.id.cautionsrv1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2 = findViewById(R.id.cautionsrv2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3 = findViewById(R.id.cautionsrv3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView4 = findViewById(R.id.cautionsrv4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));



        reference1 = FirebaseDatabase.getInstance().getReference("CovidCautions").child("Indivitual");
        reference2 = FirebaseDatabase.getInstance().getReference("CovidCautions").child("SocialSafetyPrecautions");
        reference3 = FirebaseDatabase.getInstance().getReference("CovidCautions").child("TransportSafetyPrecautions");
        reference4 = FirebaseDatabase.getInstance().getReference("CovidCautions").child("WorkplaceSafetyPrecautions");





        ValueEventListener postListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(CovidCautionsModel.class));
                }
                adapter = new CovidCautionsAdapter(CovidCautions.this, mlist);
                recyclerView1.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference1.addValueEventListener(postListener1);



        ValueEventListener postListener2 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(CovidCautionsModel.class));
                }
                adapter = new CovidCautionsAdapter(CovidCautions.this, mlist);
                recyclerView2.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference2.addValueEventListener(postListener2);
        ValueEventListener postListener3 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(CovidCautionsModel.class));
                }
                adapter = new CovidCautionsAdapter(CovidCautions.this, mlist);
                recyclerView3.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference3.addValueEventListener(postListener3);



        ValueEventListener postListener4 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(CovidCautionsModel.class));
                }
                adapter = new CovidCautionsAdapter(CovidCautions.this, mlist);
                recyclerView4.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference4.addValueEventListener(postListener4);
    }
}