package com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk;


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


import java.util.ArrayList;


public class CovidHelpDeskAdapter extends RecyclerView.Adapter<CovidHelpDeskAdapter.MyViewHolder> {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    Context context;
    ArrayList<CovidHelpDeskModel> model;

    public CovidHelpDeskAdapter(Context c, ArrayList<CovidHelpDeskModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public CovidHelpDeskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CovidHelpDeskAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.helpdesk_rcview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CovidHelpDeskAdapter.MyViewHolder holder, final int pos) {
        holder.hName.setText("☛ "+ model.get(pos).getName());



        final String Phone = model.get(pos).getContact();


        holder.hCallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mphone = model.get(pos).getContact().toString();

                String s = "tel:" + mphone;
                Intent mintent = new Intent(Intent.ACTION_VIEW);
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