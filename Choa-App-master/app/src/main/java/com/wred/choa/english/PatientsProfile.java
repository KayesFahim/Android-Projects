package com.wred.choa.english;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PatientsProfile extends AppCompatActivity {
    private ProgressDialog progressDialog;
    ArrayList<DoctorModel> mlist;
    DoctorAdapter adapter;
    DatabaseReference reference;

    Button name,login, logout;
    RecyclerView doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        doctorList = findViewById(R.id.doctorlist);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(PatientsProfile.this);
        doctorList.setLayoutManager(layoutManager);

       logout = findViewById(R.id.plogout);
       logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseAuth.getInstance().signOut();
               startActivity(new Intent(PatientsProfile.this, PatientEnglish.class));
           }
       });

        final CircularImageView circularImageView = findViewById(R.id.pimageView);

        FirebaseUser muser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Patient").child(muser.getUid());

        progressDialog = new ProgressDialog(PatientsProfile.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        reference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        ValueEventListener pList = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(DoctorModel.class));
                }
                adapter = new DoctorAdapter(PatientsProfile.this, mlist);
                doctorList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference.addValueEventListener(pList);

        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                DoctorModel user = dataSnapshot.getValue(DoctorModel.class);

                name = findViewById(R.id.patNameview);

                assert user != null;
                name.setText(user.getName());
                String userImage = user.getImgurl();

               try {
                    Glide.with(PatientsProfile.this).load("" + userImage).into(circularImageView);
               }catch (Exception e){

               }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(PatientsProfile.this, "Couldn't get data.", Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addValueEventListener(postListener);
    }

}