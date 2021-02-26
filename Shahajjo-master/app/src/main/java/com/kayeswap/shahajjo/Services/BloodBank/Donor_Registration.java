package com.kayeswap.shahajjo.Services.BloodBank;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.ServicesActivity;

import java.util.HashMap;


public class Donor_Registration extends AppCompatActivity {

    EditText memail, mname, phn, address, pw, mblood;
    Button add, pushnoty;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_reg);

        add = findViewById(R.id.rbtnadd);

        memail = findViewById(R.id.remail);
        mname = findViewById(R.id.rname);
        phn = findViewById(R.id.rphone);
        mblood = findViewById(R.id.rblood);
        address = findViewById(R.id.raddress);
        pw = findViewById(R.id.rpass);



        ///////// Main Code

        auth = FirebaseAuth.getInstance();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = memail.getText().toString().trim();
                String password = pw.getText().toString().trim();
                final String name = mname.getText().toString().trim();
                String phone = phn.getText().toString().trim();
                String blood = mblood.getText().toString().trim();
                final String add = address.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Name!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(getApplicationContext(), "Enter Phone Number!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(blood)) {
                    Toast.makeText(getApplicationContext(), "Enter Blood Group", Toast.LENGTH_LONG).show();
                    return;
                }


                if (TextUtils.isEmpty(add)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Address!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, Enter Minimum 6 Characters!", Toast.LENGTH_LONG).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Donor_Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Donor_Registration.this, "Add Member Successfully :" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                // Warning

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Donor_Registration.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    String user_id = auth.getCurrentUser().getUid();
                                    DatabaseReference DB = FirebaseDatabase.getInstance("https://shahajjo-1419f.firebaseio.com/").getReference().child("Blood").child(user_id);

                                    // User Details


                                    String nm = mname.getText().toString();
                                    String email = memail.getText().toString();
                                    String Ad = address.getText().toString();
                                    String mphone = phn.getText().toString();
                                    String blood = mblood.getText().toString();

                                    HashMap<String, Object> newPost = new HashMap<>();

                                    newPost.put("name", nm);

                                    newPost.put("email", email);

                                    newPost.put("location", Ad);

                                    newPost.put("phone", mphone);

                                    newPost.put("blood", blood);

                                    DB.setValue(newPost);

                                    Intent intent = new Intent(Donor_Registration.this, ServicesActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                        });
            }
        });


    }
}


