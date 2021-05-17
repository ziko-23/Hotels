package com.example.hotels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Hotel> hotels;

    public CustomRecyclerAdapter(Context context, List hotels) {
        this.context = context;
        this.hotels = hotels;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(hotels.get(position));
        Hotel hotel = hotels.get(position);
        holder.txtName.setText(hotel.getName());
        holder.txtnbrStars.setText(String.valueOf(hotel.getNbStars()));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtnbrStars;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtnbrStars = (TextView) itemView.findViewById(R.id.txtnbrStars);
        }
    }
}
