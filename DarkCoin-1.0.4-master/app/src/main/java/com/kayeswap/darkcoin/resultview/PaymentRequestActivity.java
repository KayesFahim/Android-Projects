package com.kayeswap.darkcoin.resultview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kayeswap.darkcoin.ProfileActivity;
import com.kayeswap.darkcoin.R;
import com.kayeswap.darkcoin.UserModel;

import java.util.Date;
import java.util.Locale;

public class PaymentRequestActivity extends AppCompatActivity {

    EditText pcoin, pmethod;
    Button pBtn;
    FirebaseAuth auth;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_request);

        pcoin = findViewById(R.id.paymentCoin);
        pmethod = findViewById(R.id.paymentMethod);
        pBtn = findViewById(R.id.paymentbtn);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        }


        auth = FirebaseAuth.getInstance();

        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coin = pcoin.getText().toString().trim();
                String method = pmethod.getText().toString().trim();

                if (TextUtils.isEmpty(coin)) {
                    Toast.makeText(getApplicationContext(), "Enter Amount In Coin", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(method)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Payment Method", Toast.LENGTH_LONG).show();
                    return;
                }

                String user_id = auth.getCurrentUser().getUid();
                DatabaseReference DB = FirebaseDatabase.getInstance().getReference().child("Invoice");

                // User Details


                UserModel model = new UserModel(coin, method);

                DB.child(user_id).child(currentDate).setValue(model);
                Toast.makeText(PaymentRequestActivity.this, "Payment Request Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(PaymentRequestActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();



            }
        });


    }
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }
}
