package com.kayeswap.shahajjo.Services.Covid19.CoronaNews;



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


import java.util.ArrayList;


public class CoronaNewsAdapter extends RecyclerView.Adapter<CoronaNewsAdapter.MyViewHolder> {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    Context context;
    ArrayList<CoronaNewsModel> model;

    public CoronaNewsAdapter(Context c, ArrayList<CoronaNewsModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public CoronaNewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CoronaNewsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.corona_news_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CoronaNewsAdapter.MyViewHolder holder,final int pos) {

        holder.newsTitle.setText("☉ "+ model.get(pos).getTitle());

        String title = model.get(pos).title;
        String blog = model.get(pos).blog;

        holder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), NewsDetails.class);
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
            newsTitle =  itemView.findViewById(R.id.coronanews_title);


        }

    }
}