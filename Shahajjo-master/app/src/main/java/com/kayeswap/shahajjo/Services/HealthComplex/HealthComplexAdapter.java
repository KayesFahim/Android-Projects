package com.kayeswap.shahajjo.Services.HealthComplex;


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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk.CovidHelpDeskModel;

import java.util.ArrayList;


public class HealthComplexAdapter extends RecyclerView.Adapter<HealthComplexAdapter.MyViewHolder> {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    Context context;
    ArrayList<HealthComplexModel> model;

    public HealthComplexAdapter(Context c, ArrayList<HealthComplexModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public HealthComplexAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HealthComplexAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.health_complex_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final HealthComplexAdapter.MyViewHolder holder, final int pos) {
        holder.hName.setText("☛ "+ model.get(pos).getName());



        final String Phone = model.get(pos).getContact();


        holder.hCallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mphone = model.get(pos).getContact().toString();

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
        TextView hName, hCallbtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            hName =  itemView.findViewById(R.id.helpdesk_name);
            hCallbtn =  itemView.findViewById(R.id.helpdesk_contact);
        }

    }
}