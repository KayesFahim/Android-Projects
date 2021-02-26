package com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;


import java.util.ArrayList;

public class PlasmaDonorList extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PlasmaModel> mlist;
    PlasmaAdapter adapter;
    Button BePlasmaDonorbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma_donor_list);


            BePlasmaDonorbtn = findViewById(R.id.pdonorbtn);
            BePlasmaDonorbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(PlasmaDonorList.this, BePlasmaDonor.class));

                }
            });



            recyclerView = findViewById(R.id.plasmarv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));



            reference = FirebaseDatabase.getInstance().getReference().child("Plasma");



            Query query;
            query = FirebaseDatabase.getInstance().getReference("Plasma")
                    .orderByChild("blood")
                    .limitToFirst(100);


            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    mlist = new ArrayList<>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        mlist.add(ds.getValue(PlasmaModel.class));
                    }
                    adapter = new PlasmaAdapter(PlasmaDonorList.this, mlist);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(PlasmaDonorList.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
}


