package com.wred.choa.chat;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wred.choa.R;
import com.wred.choa.english.DoctorProfile;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyHolder> {

    private static final int MSG_Type_Left =0;
    private static final int MSG_Type_Right =0;

    Context context;

    List<ChatModel> mList;
    String imgUrl;
    FirebaseUser user;

    public ChatAdapter(Context context, List<ChatModel> mList, String imgUrl) {
        this.context = context;
        this.mList = mList;
        this.imgUrl = imgUrl;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        if(i==MSG_Type_Right){
            View view = LayoutInflater.from(context).inflate(R.layout.chat_right, parent, false);
            return new MyHolder(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.chat_left, parent, false);
            return new MyHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        String messege = mList.get(position).getMessageText();
        String date = mList.get(position).getMessageTime();

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(date));

        String Datetime = DateFormat.format("dd/MM/yyyy hh:mm aa",cal).toString();

        try{
            Glide.with(context).load(""+imgUrl).into(holder.circularImageView);
        }catch(Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(mList.get(position).getMessageSender().equals(user.getUid())){
            return MSG_Type_Right;
        }else{
            return MSG_Type_Left;
        }

    }

    class MyHolder extends RecyclerView.ViewHolder{
        CircularImageView circularImageView;
        TextView name, time, chatsms;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            circularImageView = itemView.findViewById(R.id.dpimage);
            name = itemView.findViewById(R.id.nameview);
            time = itemView.findViewById(R.id.mydate);
            chatsms = itemView.findViewById(R.id.smsview);

        }
    }



    }
