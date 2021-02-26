package com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;;

import java.util.ArrayList;

public class RequestPlasma extends AppCompatActivity {
    DatabaseReference reference;
    FirebaseUser loginuser;
    RecyclerView recyclerView;
    ArrayList<PlasmaRequestModel> list;
    PlasmaRequestAdapter adapter;
    Button btn;
    String userBlood;
    EditText mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_plasma);

        btn = findViewById(R.id.preqbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RequestPlasma.this, RequestForPlasma.class));

            }
        });



        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        loginuser = FirebaseAuth.getInstance().getCurrentUser();


        Query query;
        query = FirebaseDatabase.getInstance().getReference("PlasmaRequest")
                .orderByChild("time")
                .limitToFirst(100)
                .startAt(userBlood);


        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    list.add(ds.getValue(PlasmaRequestModel.class));
                }
                adapter = new PlasmaRequestAdapter(RequestPlasma.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RequestPlasma.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

