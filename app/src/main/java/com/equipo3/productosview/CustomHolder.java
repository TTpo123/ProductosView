package com.equipo3.productosview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView tvTitle;
    public TextView tvDesc;
    public CardView cardItemView;

    public CustomHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDesc = itemView.findViewById(R.id.tvDesc);
        cardItemView = itemView.findViewById(R.id.cardItemView);
    }
}
