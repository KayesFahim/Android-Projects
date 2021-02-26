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
import com.wred.choa.R;
import com.wred.choa.chat.Chat;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MyViewHolder> {


    Context context;
    ArrayList<PatientModel> model;

    public PatientAdapter(Context c, ArrayList<PatientModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public PatientAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.patient_list, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final PatientAdapter.MyViewHolder holder, final int pos) {
        holder.pName.setText(model.get(pos).getName());
        holder.pAge.setText(model.get(pos).getAge()+", ");
        holder.pLocation.setText(model.get(pos).getLocation());

        String imgUrl = model.get(pos).getImgurl();

        try{
            Glide.with(context).load(""+imgUrl).into(holder.profic);
        }catch(Exception e){

        }

        final String hisUid = model.get(pos).getId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mintent = new Intent(context, Chat.class);
                mintent.putExtra("hisUid", hisUid);
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
        TextView pName, pAge, pLocation;
        CircularImageView profic;
        public MyViewHolder(View itemView) {
            super(itemView);
            pName =  itemView.findViewById(R.id.nameview);
            pAge =  itemView.findViewById(R.id.ageview);
            pLocation =  itemView.findViewById(R.id.location);
            profic =  itemView.findViewById(R.id.dpimage);

        }

    }
}