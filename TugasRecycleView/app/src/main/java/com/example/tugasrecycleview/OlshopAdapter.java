package com.example.tugasrecycleview;

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

import java.util.ArrayList;

public class OlshopAdapter extends RecyclerView.Adapter<OlshopAdapter.OlshopViewHolder> {
    private ArrayList<Olshop> listData = new ArrayList<>();

    public void setData(ArrayList<Olshop> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public OlshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutbaru,parent,false);
        return new OlshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OlshopViewHolder holder, int position) {
        holder.bind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class OlshopViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv1;
        private TextView tv1;
        private Button btnShare, btnPreview;

        public OlshopViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
            btnPreview = itemView.findViewById(R.id.btn_preview);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
        public void bind(Olshop vars) {
            tv1.setText(vars.getNama());
            Glide.with(itemView.getContext()).load(vars.getLogo()).into(iv1);
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Mari Belanja Di " + vars.getNama();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    itemView.getContext().startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
            });
            btnPreview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(itemView.getContext(),DetailActivity.class);
                    detail.putExtra("extra",vars);
                    itemView.getContext().startActivity(detail);
                }
            });
        }
    }
}
