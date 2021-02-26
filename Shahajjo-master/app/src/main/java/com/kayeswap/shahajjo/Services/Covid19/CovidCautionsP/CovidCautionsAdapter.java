package com.kayeswap.shahajjo.Services.Covid19.CovidCautionsP;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.CoronaNews.CoronaNewsModel;
import com.kayeswap.shahajjo.Services.Covid19.CoronaNews.NewsDetails;

import java.util.ArrayList;


public class CovidCautionsAdapter extends RecyclerView.Adapter<CovidCautionsAdapter.MyViewHolder> {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    Context context;
    ArrayList<CovidCautionsModel> model;

    public CovidCautionsAdapter(Context c, ArrayList<CovidCautionsModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public CovidCautionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CovidCautionsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.corona_cautions_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CovidCautionsAdapter.MyViewHolder holder, final int pos) {

        holder.newsTitle.setText("✪ "+ model.get(pos).getTitle());

        String title = model.get(pos).title;
        String blog = model.get(pos).blog;

        holder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CautionsDetails.class);
                i.putExtra("title",  model.get(pos).getTitle());
                view.getContext().startActivity(i);
                i.putExtra("blog", model.get(pos).getBlog());
                view.getContext().startActivity(i);

            }
        });


    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView newsTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            newsTitle =  itemView.findViewById(R.id.coronacaution_title);


        }

    }
}