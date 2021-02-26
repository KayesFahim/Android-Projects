package com.wred.choa.english;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wred.choa.R;

import java.util.ArrayList;

public class DoctorProfile extends AppCompatActivity {
    private ProgressDialog progressDialog;
    ArrayList<PatientModel> mlist;
    PatientAdapter adapter;
    DatabaseReference mreference;

    Button dname, logout;
    RecyclerView patientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        patientList = findViewById(R.id.patientlist);
        patientList.setLayoutManager(new LinearLayoutManager(this));

        logout = findViewById(R.id.dlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(DoctorProfile.this, DoctorEnglish.class));
            }
        });

        final CircularImageView circularImageView = findViewById(R.id.dimageView);




        FirebaseUser muser = FirebaseAuth.getInstance().getCurrentUser();

        progressDialog = new ProgressDialog(DoctorProfile.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        assert muser != null;
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Doctor").child(muser.getUid());
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                DoctorModel user = dataSnapshot.getValue(DoctorModel.class);

                dname = findViewById(R.id.dNview);

                assert user != null;
                dname.setText(user.getName());
                String userImage = user.getImgurl();

                try {
                    Glide.with(DoctorProfile.this).load("" + userImage).into(circularImageView);
                }catch (Exception e){

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(DoctorProfile.this, "Couldn't get data.", Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addValueEventListener(postListener);




        mreference = FirebaseDatabase.getInstance().getReference().child("Patient");

        ValueEventListener pList = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(PatientModel.class));
                }
                adapter = new PatientAdapter(DoctorProfile.this, mlist);
                patientList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mreference.addValueEventListener(pList);

    }

}