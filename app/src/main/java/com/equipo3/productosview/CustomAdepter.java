package com.equipo3.productosview;

import com.bumptech.glide.Glide;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdepter extends RecyclerView.Adapter<CustomHolder> {

    private Context context;
    private ArrayList<CustomModel> customModelArrayList;

    public CustomAdepter(Context context, ArrayList<CustomModel> customModelArrayList) {
        this.context = context;
        this.customModelArrayList = customModelArrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del ítem del RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        CustomModel model = customModelArrayList.get(position);

        // Carga la imagen desde la URL utilizando Glide
        Glide.with(context)
                .load(model.getImageUrl())
                .placeholder(R.drawable.placeholder_image) // Asegúrate de tener un drawable de placeholder
                .into(holder.imageView);

        holder.tvTitle.setText(model.getTitle());
        holder.tvDesc.setText(model.getDesc());

        holder.cardItemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity2.class);
            intent.putExtra("icon", model.getImageUrl()); // Pasar URL de la imagen
            intent.putExtra("title", model.getTitle());
            intent.putExtra("desc", model.getDesc());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return customModelArrayList.size();
    }

    public void filterList(ArrayList<CustomModel> filteredList) {
        this.customModelArrayList = filteredList;
        notifyDataSetChanged(); // Notifica que los datos han cambiado
    }
}
