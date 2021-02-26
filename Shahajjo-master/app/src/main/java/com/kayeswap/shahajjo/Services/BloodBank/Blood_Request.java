package com.kayeswap.shahajjo.Services.BloodBank;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.kayeswap.shahajjo.R;

import java.util.ArrayList;

public class Blood_Request extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseUser loginuser;
    RecyclerView recyclerView;
    ArrayList<BloodRequestModel> list;
    BloodRequestAdapter adapter;
    Button btn;
    String userBlood;
    EditText mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_request);

            btn = findViewById(R.id.requestbtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Blood_Request.this, RequestForBlood.class));

                }
            });



            recyclerView = findViewById(R.id.recycleview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));




            loginuser = FirebaseAuth.getInstance().getCurrentUser();

           reference = FirebaseDatabase.getInstance().getReference().child("Blood_Request");



        Query query;
        query = FirebaseDatabase.getInstance().getReference("Blood_Request")
                .orderByChild("blood")
                .limitToFirst(100)
                .startAt(userBlood);


        query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list = new ArrayList<>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(BloodRequestModel.class));
                    }
                    adapter = new BloodRequestAdapter(Blood_Request.this, list);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Blood_Request.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
}

