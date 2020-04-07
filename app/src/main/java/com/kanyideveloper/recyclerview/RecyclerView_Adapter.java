package com.kanyideveloper.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {

    private List<DevelopersList> developersLists;
    private Context context;

    public RecyclerView_Adapter(List<DevelopersList> developersLists, Context context) {

        //Initialize the List and Context
        this.developersLists = developersLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        
        final DevelopersList developersList = developersLists.get(position);
        
        holder.userName.setText(developersList.getDetails());
        holder.url.setText(developersList.getGithub_url());

        Glide.with(context)
                .load(developersList.getImage_url())
                .into(holder.image);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,developersList.getDetails(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView userName;
        TextView url;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            userName = itemView.findViewById(R.id.userName);
            url = itemView.findViewById(R.id.developerUrl);
        }
    }
}
