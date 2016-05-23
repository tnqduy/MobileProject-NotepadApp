package com.example.akduy.demonotepadapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView title;
    public TextView content;
    public ImageView image;
    public LinearLayout titlecontentholder;

    public RecyclerViewHolder(View itemView)
    {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.txtTitle);
        content = (TextView) itemView.findViewById(R.id.txtContent);

        title.setOnClickListener(this);
        content.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        MainActivity.onRecyclerItemClick(getAdapterPosition());
    }
}
