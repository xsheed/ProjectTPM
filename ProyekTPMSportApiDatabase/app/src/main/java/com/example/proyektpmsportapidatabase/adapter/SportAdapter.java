package com.example.proyektpmsportapidatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.model.sport.SportsItem;
import com.example.proyektpmsportapidatabase.view.activity.AddActivity;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {
    private ArrayList<SportsItem> sportsItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<SportsItem> items) {
        sportsItems.clear();
        sportsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_sport,parent,false);
        return new SportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        holder.bind(sportsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sportsItems.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContent;
        TextView sportName;
        Button btnAdd;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContent = itemView.findViewById(R.id.img_content);
            sportName = itemView.findViewById(R.id.t_title_content);
            btnAdd = itemView.findViewById(R.id.btn_addnote);
        }

        public void bind(SportsItem sportsItem) {
            Glide.with(itemView.getContext()).load(sportsItem.getStrSportThumb()).into(imgContent);
            sportName.setText(sportsItem.getStrSport());

            btnAdd.setOnClickListener(v -> {
                Intent addNote = new Intent(itemView.getContext(), AddActivity.class);
                addNote.putExtra("sportname", sportsItem.getStrSport());
                itemView.getContext().startActivity(addNote);
            });

        }
    }
}
