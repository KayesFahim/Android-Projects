package com.kayeswap.shahajjo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kayeswap.shahajjo.Services.BloodBank.Donor_Registration;



public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    TextView regl;
    EditText loginemail, loginpassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignInActivity.this, ServicesActivity.class));
            finish();
        } else {


            loginemail = findViewById(R.id.lemail);
            loginpassword = findViewById(R.id.lpass);
            login = findViewById(R.id.loginbtn);
            regl = findViewById(R.id.reglink);


            regl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SignInActivity.this, Donor_Registration.class);
                    startActivity(intent);
                    finish();
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String lgemail = loginemail.getText().toString().trim();
                    String lgpassword = loginpassword.getText().toString().trim();


                    if (TextUtils.isEmpty(lgemail)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_LONG).show();
                        return;
                    }


                    if (TextUtils.isEmpty(lgpassword)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (lgpassword.length() < 6) {
                        Toast.makeText(getApplicationContext(), "Password too short, Enter Minimum 6 Characters!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    //create user
                    auth.signInWithEmailAndPassword(lgemail, lgpassword)
                            .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignInActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        // User Details
                                        Toast.makeText(SignInActivity.this, "Login Successfully :" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(SignInActivity.this, ServicesActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                            });
                }
            });
        }
    }
}
