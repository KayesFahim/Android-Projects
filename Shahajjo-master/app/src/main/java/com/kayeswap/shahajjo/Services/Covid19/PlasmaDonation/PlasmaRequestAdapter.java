package com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation;


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kayeswap.shahajjo.R;

import java.util.ArrayList;


public class PlasmaRequestAdapter extends RecyclerView.Adapter<PlasmaRequestAdapter.MyViewHolder> {


    Context context;
    ArrayList<PlasmaRequestModel> model;

    public PlasmaRequestAdapter(Context c, ArrayList<PlasmaRequestModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.plasmarequest_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int pos) {
        holder.bloodreqall.setText(model.get(pos).getName() + " " + model.get(pos).getRelation() + " Need " + model.get(pos).getHow() + " " + model.get(pos).getBlood() + " Plasma For " + model.get(pos).getProblem() +
                " in " + model.get(pos).getLocation() + " Hospital at " + model.get(pos).getTime());



        holder.bCallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mphone = model.get(pos).getPhone().toString();


                String s = "tel:" + mphone;
                Intent mintent = new Intent(Intent.ACTION_DIAL);
                mintent.setData(Uri.parse(s));

                try {
                    context.startActivity(mintent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Toast.makeText(context, "You Dont have Any Dialar App", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView bloodreqall, bCallbtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            bloodreqall =  itemView.findViewById(R.id.bloodName);
            bCallbtn =  itemView.findViewById(R.id.bcontact);
        }

    }
}
