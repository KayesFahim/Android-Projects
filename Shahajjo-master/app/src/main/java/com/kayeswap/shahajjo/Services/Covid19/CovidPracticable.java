package com.kayeswap.shahajjo.Services.Covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;

import java.util.ArrayList;

public class CovidPracticable extends AppCompatActivity {

    ListView listview;

    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    PracticableModel data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_precticable);

        data = new PracticableModel();

        listview = findViewById(R.id.plist);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("PracticableCovid");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.useInfo, list);


        Query query = FirebaseDatabase.getInstance().getReference("PracticableCovid")
                .orderByChild("text").limitToFirst(1000);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    data = ds.getValue(PracticableModel.class);
                    list.add("⋆ " +data.getText());
                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
