package com.kayeswap.shahajjo.Services.BloodBank.BloodGroups;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
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
import com.kayeswap.shahajjo.Services.BloodBank.Donor_Registration;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.User;

import java.util.ArrayList;

public class B_Negative extends AppCompatActivity {

    ListView listview;
    SearchView searchView;
    Button sb, be,tit;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__negative);
        listview = findViewById(R.id.apblood);
        searchView = findViewById(R.id.bns);
        be = findViewById(R.id.apbead);
        tit = findViewById(R.id.aptitle);



        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B_Negative.this, Donor_Registration.class));
            }
        });


        user = new User();

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Blood");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.useInfo, list);


        Query query = FirebaseDatabase.getInstance().getReference("Blood")
                .orderByChild("blood").limitToLast(1000)
                .equalTo("B-");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    user = ds.getValue(User.class);
                    list.add("Name: " + user.getName() + '\n' + "Phone: " + user.getPhone() + '\n'
                            + "Blood Group: " + user.getBlood() + '\n' + "Location: " + user.getLocation());
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

