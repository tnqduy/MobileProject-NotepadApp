package com.example.akduy.demonotepadapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CustomIconLabelAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    Context context;
    List<NoteItem> items;

    public CustomIconLabelAdapter(Context context, List<NoteItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.note_recycler_item_layout, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.title.setText(items.get(position).get_title());
        holder.content.setText(items.get(position).get_title());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
