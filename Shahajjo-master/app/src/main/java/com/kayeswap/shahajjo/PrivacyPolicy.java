package com.kayeswap.shahajjo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class PrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        TextView link = (TextView) findViewById(R.id.link);
        String linkText = "& <a href='https://shahajjoapp.blogspot.com/p/privacy-policy.html'>Read More </a> Here";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());

        CheckBox c1 = findViewById(R.id.policycheck);
        Button btnn = findViewById(R.id.accept);
        btnn.setVisibility(View.INVISIBLE);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    btnn.setVisibility(View.VISIBLE);
                }else{
                    btnn.setVisibility(View.GONE);
                    Toast.makeText(PrivacyPolicy.this, "Please Accept privacy Policy", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrivacyPolicy.this, ServicesActivity.class));
            }
        });


    }
}
