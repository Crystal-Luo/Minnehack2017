package com.cl.medlog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by qwert on 1/29/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    List<HistoryItem> items;
    int itemLayout;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView message;
        public ViewHolder (View v) {
            super(v);
            date = (TextView) v.findViewById(R.id.card_date);
            message = (TextView) v.findViewById(R.id.card_message);
        }
    }

    public HistoryAdapter(List<HistoryItem> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryItem item = items.get(position);
        holder.date.setText(item.getDate());
        holder.message.setText(item.getMessage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
