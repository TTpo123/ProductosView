package com.equipo3.productosview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    ImageView getImageView;
    TextView tvGeTitle, tvGetDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getImageView = findViewById(R.id.getImageView);
        tvGeTitle = findViewById(R.id.tvGeTitle);
        tvGetDesc = findViewById(R.id.tvGetDesc);

        Intent intent = getIntent();

        String getTitle = intent.getStringExtra("title");
        String getDesc = intent.getStringExtra("desc");
        String getImageUrl = intent.getStringExtra("icon"); // Obtener URL de la imagen

        tvGeTitle.setText(getTitle);
        tvGetDesc.setText(getDesc);

        // Cargar la imagen desde la URL utilizando Glide
        Glide.with(this)
                .load(getImageUrl)
                .placeholder(R.drawable.python) // Imagen de reemplazo en caso de error
                .into(getImageView);
    }
}
