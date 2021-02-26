package com.wred.choa.english;

import android.content.Context;
import android.content.Intent;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wred.choa.R;
import com.wred.choa.chat.Chat;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {


    Context context;
    ArrayList<DoctorModel> model;
    FirebaseUser firebaseUser;

    public DoctorAdapter(Context c, ArrayList<DoctorModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public DoctorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DoctorAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.doctor_list, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final DoctorAdapter.MyViewHolder holder, final int pos) {
        holder.dName.setText(model.get(pos).getName());
        holder.dTag.setText(model.get(pos).getTag());

        String imgUrl = model.get(pos).getImgurl();

        try{
            Glide.with(context).load(""+imgUrl).into(holder.dprofic);
        }catch(Exception e){

        }

        final String hisUid = model.get(pos).getId();
        final String hisImage= model.get(pos).getImgurl();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        final String myUid = user.getUid();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mintent = new Intent(context, Chat.class);
                context.startActivity(mintent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView dName, dTag;
        CircularImageView dprofic;
        public MyViewHolder(View itemView) {
            super(itemView);
            dName =  itemView.findViewById(R.id.dnameview);
            dTag =  itemView.findViewById(R.id.dtagview);
            dprofic =  itemView.findViewById(R.id.dimage);

        }

    }
}