package com.kayeswap.darkcoin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Registration extends AppCompatActivity {

    EditText Username, Email, Phone, Ref, Password;
    Button SignUp;
    String editTextCoin="100";

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextEmail);
        Phone = findViewById(R.id.editTextPhone);
        Ref = findViewById(R.id.editTextRef);
        Password = findViewById(R.id.editTextPassWord);

        SignUp = findViewById(R.id.Regbutton);



        ///////// Main Code

        auth = FirebaseAuth.getInstance();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                final String name = Username.getText().toString().trim();
                String phone = Phone.getText().toString().trim();


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
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Registration.this, "Add Member Successfully :" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                // Warning

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Registration.this, "Authentication failed. Try Again" + task.getException(),
                                            Toast.LENGTH_LONG).show();
                                } else {

                                    String user_id = auth.getCurrentUser().getUid();
                                    DatabaseReference DB = FirebaseDatabase.getInstance().getReference().child("User");

                                    // User Details


                                    final String email = Email.getText().toString().trim();
                                    final String name = Username.getText().toString().trim();
                                    String phone = Phone.getText().toString().trim();
                                    String ref = Ref.getText().toString().trim();
                                    final String coin = editTextCoin.trim();

                                    UserModel model = new UserModel(name , email, phone, ref, coin);

                                    DB.child(user_id).setValue(model);

                                    Intent intent = new Intent(Registration.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                        });
            }
        });


    }
}


