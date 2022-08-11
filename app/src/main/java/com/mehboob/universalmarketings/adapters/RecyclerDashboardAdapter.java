package com.mehboob.universalmarketings.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehboob.universalmarketings.Models.RecyclerDashboardModel;
import com.mehboob.universalmarketings.R;

import java.util.ArrayList;

public class RecyclerDashboardAdapter extends RecyclerView.Adapter<RecyclerDashboardAdapter.viewHolder> {
    Context context;
    ArrayList<RecyclerDashboardModel> list;

    public RecyclerDashboardAdapter(Context context, ArrayList<RecyclerDashboardModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_dashboard, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RecyclerDashboardModel data = list.get(position);

        holder.iv.setImageResource(data.getImage());
        holder.tv.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.recyclerTitle);
            iv = itemView.findViewById(R.id.recyclerImage);
        }
    }
}
