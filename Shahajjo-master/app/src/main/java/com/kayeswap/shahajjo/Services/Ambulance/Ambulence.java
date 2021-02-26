package com.kayeswap.shahajjo.Services.Ambulance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;

import java.util.ArrayList;

public class Ambulence extends AppCompatActivity {
    ListView listview;
    SearchView searchView;
    Button be,tit;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Ambulence_DataModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulence);
        listview = findViewById(R.id.ambulence);
        searchView = findViewById(R.id.ans);


        user = new Ambulence_DataModel();

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Blood");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.useInfo, list);


        Query query = FirebaseDatabase.getInstance().getReference("Ambulence")
                .orderByChild("Location").limitToLast(1000);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    user = ds.getValue(Ambulence_DataModel.class);
                    list.add("Name: " + user.getName() + '\n' + "Phone: " + user.getContact() + '\n'
                            +                            "Location: " + user.getLocation());
                }
                listview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });
    }


}

