package com.kayeswap.shahajjo.Services.Covid19;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk.CovidTestHelpLine;
import com.kayeswap.shahajjo.Services.Covid19Activity;

public class CovidTest extends AppCompatActivity {
    CheckBox q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    Button btnTest, BtnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_test);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);
        q10 = findViewById(R.id.q10);

        btnTest = findViewById(R.id.testBtn);
        BtnMore = findViewById(R.id.btnMore);



        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(q1.isChecked() && q2.isChecked() && q3.isChecked() && q4.isChecked() && q5.isChecked() && q6.isChecked() && q7.isChecked() && q8.isChecked()
                        && q9.isChecked() && q10.isChecked()){

                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("Your Condition is So Bad Please appoint to the doctor Asap")
                            .setPositiveButton("Helpline", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidHelpDesk.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();


                }else if(q1.isChecked() && q2.isChecked() && q4.isChecked()){

                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("Your on Risky Situation , Conatct With Doctor Asap")
                            .setPositiveButton("Helpline", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidHelpDesk.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }else if(q3.isChecked() || q5.isChecked() || q6.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("Your On Denger Zone , Serious Sysmptoms is showing on you , Asap Go For Isolation")
                            .setPositiveButton("Helpline", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidHelpDesk.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();



                }else if(q1.isChecked() && q2.isChecked() && q3.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("Your On Denger Zone , Serious sysmptoms is showing on you , Asap Go For Isolation")
                            .setPositiveButton("Helpline", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidHelpDesk.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }else if(q7.isChecked() || q8.isChecked() || q9.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("You Have Chances To Affected with covid 19 , Stay Home , Dont Go out side next 14 days, if show any symptoms, Test Covid")
                            .setPositiveButton("Covid Test Helpline", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidTestHelpLine.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CovidTest.this);
                    builder.setMessage("Your Dont Have Any Serious Symptoms of Covid 19 , But Dont Go Outside, Dont go crowded place, Stay Home , Stay Safe")
                            .setPositiveButton("Precautions", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(CovidTest.this, CovidPracticable.class));

                                }
                            })
                            .setNegativeButton("Dismiss", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();



                }
            }
        });

        BtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CovidTest.this, Covid19Activity.class));

            }
        });

    }
}
