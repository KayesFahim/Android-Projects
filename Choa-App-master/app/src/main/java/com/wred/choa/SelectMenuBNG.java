package com.wred.choa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wred.choa.bangla.DoctorBangla;
import com.wred.choa.bangla.PatientBangla;
import com.wred.choa.english.DoctorEnglish;
import com.wred.choa.english.PatientEnglish;

public class SelectMenuBNG extends AppCompatActivity {
    Button doctor, patient, bng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu_b_n_g);
        doctor = findViewById(R.id.amidoctor);
        patient = findViewById(R.id.amirugi);
        bng = findViewById(R.id.eng);

        bng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuBNG.this, SelectMenuENG.class));
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuBNG.this, DoctorEnglish.class));
            }
        }); doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuBNG.this, DoctorBangla.class));
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuBNG.this, PatientBangla.class));
            }
        });
    }
}