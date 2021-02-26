package com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk;

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
import com.kayeswap.shahajjo.Services.Covid19.Covid19LabTest.CovidLabTestAdapter;
import com.kayeswap.shahajjo.Services.Covid19.Covid19LabTest.CovidLabTestModel;


import java.util.ArrayList;

public class CovidTestHelpLine extends AppCompatActivity {

    String[] divition ={ "Dhaka","Chittagong", "Sylhet", "Barishal", "Khulna", "Rajshahi", "Rangpur","Mymansing"

    };

    DatabaseReference reference;

    Spinner mspinner;
    RecyclerView recyclerView;
    ArrayList<CovidLabTestModel> mlist;
    CovidLabTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_test_help_line);

        recyclerView = findViewById(R.id.healthcomplexrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mspinner = findViewById(R.id.spinnerid);

        ArrayAdapter<String> dlist = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, divition);
        dlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(dlist);


        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValue = mspinner.getSelectedItem().toString();
                Toast.makeText(getBaseContext(), spinnerValue+ " Divition Selected" , Toast.LENGTH_SHORT).show();
                reference = FirebaseDatabase.getInstance().getReference("Covid19Test").child(spinnerValue);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mlist = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            mlist.add(ds.getValue(CovidLabTestModel.class));
                        }
                        adapter = new CovidLabTestAdapter(CovidTestHelpLine.this, mlist);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(CovidTestHelpLine.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
