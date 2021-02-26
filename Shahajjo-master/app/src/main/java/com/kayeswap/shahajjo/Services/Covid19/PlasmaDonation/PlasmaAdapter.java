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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.kayeswap.shahajjo.R;


import java.util.ArrayList;


public class PlasmaAdapter extends RecyclerView.Adapter<PlasmaAdapter.MyViewHolder> {


    Context context;
    ArrayList<PlasmaModel> model;

    public PlasmaAdapter(Context c, ArrayList<PlasmaModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public PlasmaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlasmaAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.plasma_list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PlasmaAdapter.MyViewHolder holder, final int pos) {
        holder.pName.setText("Name: "+ model.get(pos).getName());
        holder.pAge.setText("Age: "+model.get(pos).getAge());
        holder.pLocation.setText("Location: "+model.get(pos).getLocation());
        holder.pBlood.setText(model.get(pos).getBlood());



        holder.pCallbtn.setOnClickListener(new View.OnClickListener() {
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
        TextView pName, pAge, pLocation, pBlood, pCallbtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            pName =  itemView.findViewById(R.id.plasmaName);
            pAge =  itemView.findViewById(R.id.plasmaAge);
            pBlood =  itemView.findViewById(R.id.pbloodgroup);
            pLocation =  itemView.findViewById(R.id.plasmaAddress);
            pCallbtn =  itemView.findViewById(R.id.contact);
        }
        public void onClick()
        {
            pCallbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}