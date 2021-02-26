package com.wred.choa.chat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wred.choa.R;
import java.util.HashMap;


public class Chat extends AppCompatActivity {
    Button sendBtn, Topname;
    EditText chattxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        sendBtn = findViewById(R.id.sendButton);
        chattxt = findViewById(R.id.smsbox);
        Topname = findViewById(R.id.chatNameview);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String messege = chattxt.getText().toString().trim();

                if(TextUtils.isEmpty(messege)){
                    Toast.makeText(Chat.this, "You cannot Send Empty Sms", Toast.LENGTH_SHORT).show();
                }else{
                    sendChat(messege);
                }

            }
        });

    }

    private void sendChat(String messege) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String myUid = user.getUid();
        String hisUid = user.getUid();

        String date = String.valueOf(System.currentTimeMillis());

        HashMap<String , Object> map = new  HashMap<>();
        map.put("messageSender", myUid);
        map.put("messageReciever", hisUid);
        map.put("messageText", messege);
        map.put("messageTime", date);


        reference.child("Chats").push().setValue(map);

        chattxt.setText("");

    }
}