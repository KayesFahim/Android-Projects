package com.kayeswap.shahajjo.Services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.HealthComplex.HealthComplexAdapter;
import com.kayeswap.shahajjo.Services.HealthComplex.HealthComplexModel;


import java.util.ArrayList;


public class HealthComplexActivity extends AppCompatActivity {

    String[] districtname= {
            "Dhaka",
            "Bagerhat",
            "Barguna",
            "Barisal",
            "Bhola",
            "Jhalokati",
            "Patuakhali",
            "Pirojpur",
            "Bandarban",
            "Brahmanbaria",
            "Chandpur",
            "Chittagong",
            "Comilla",
            "Cox's Bazar",
            "Feni",
            "Khagrachhari",
            "Lakshmipur",
            "Noakhali",
            "Rangamati",
            "Faridpur",
            "Gopalganj",
            "Gazipur",
            "Madaripur",
            "Manikganj",
            "Munshiganj",
            "Narayanganj",
            "ERajbari",
            "Narsingdhi",
            "Shariatpur",
            "Tangail",
            "Chuadanga",
            "Jessore",
            "Jhenaidah",
            "Khulna",
            "Kushtia",
            "Magura",
            "Meherpur",
            "Narail",
            "Satkhira",
            "Jamalpur",
            "Mymensingh",
            "Netrokona",
            "Sherpur ",
            "Bogra",
            "Joypurhat",
            "Naogaon",
            "Natore",
            "Chapai Nawabganj",
            "Pabna",
            "Rajshahi",
            "Sirajganj",
            "Dinajpur",
            "Gaibandha",
            "Kurigram",
            "Lalmonirhat",
            "Nilphamari",
            "Panchagarh",
            "Rangpur",
            "Thakurgaon",
            "Moulvibazar",
            "Sunamganj",
            "Sylhet",
    };

    DatabaseReference reference;

    Spinner mspinner;
    RecyclerView recyclerView;
    ArrayList<HealthComplexModel> mlist;
    HealthComplexAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_complex);

        recyclerView = findViewById(R.id.healthcomplexrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mspinner = findViewById(R.id.spinnerid);

        ArrayAdapter<String> dlist = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districtname);
        dlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(dlist);


        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValue = mspinner.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), spinnerValue+ " District Selected" , Toast.LENGTH_SHORT).show();
                reference = FirebaseDatabase.getInstance().getReference("HealthComplex").child(spinnerValue);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mlist = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            mlist.add(ds.getValue(HealthComplexModel.class));
                        }
                        adapter = new HealthComplexAdapter(HealthComplexActivity.this, mlist);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(HealthComplexActivity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

}