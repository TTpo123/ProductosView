package com.equipo3.productosview.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.equipo3.productosview.CustomModel;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<CustomModel>> customModelLiveData;
    private FirebaseStorage storage;

    public HomeViewModel() {
        storage = FirebaseStorage.getInstance();
        customModelLiveData = new MutableLiveData<>();
        populateList();
    }

    public LiveData<ArrayList<CustomModel>> getCustomModelLiveData() {
        return customModelLiveData;
    }

    private void populateList() {
        String[] imagePaths = {
                "gs://primera-entrega-24921.appspot.com/pngwing.com (1).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (2).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (3).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (4).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (5).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (6).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (7).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (8).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (9).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (10).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (11).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (12).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (13).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (14).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (15).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (16).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (17).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (18).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (19).png",
                "gs://primera-entrega-24921.appspot.com/pngwing.com (20).png"
        };

        String[] titles = {
                "Smartphone X1", "Laptop Pro 15", "Auriculares Inalámbricos", "TV Ultra HD 4K",
                "Reloj Inteligente Serie 6", "Altavoz Bluetooth", "Consola de Juegos", "Ratón Inalámbrico",
                "Silla Ergonómica", "SSD Portátil", "Cámara de Acción", "Auriculares con Cancelación de Ruido",
                "Hub para el Hogar Inteligente", "Lámpara de Escritorio LED", "Monitor para Juegos", "Drone 4K",
                "Tableta Pro", "Patinete Eléctrico", "Termostato Inteligente", "Cargador Inalámbrico"
        };

        String[] descriptions = {
                "El último smartphone con pantalla completa y conectividad 5G.",
                "Una laptop de alto rendimiento con pantalla Retina de 15 pulgadas y procesadores rápidos.",
                "Auriculares inalámbricos compactos con cancelación de ruido y larga duración de batería.",
                "Un impresionante TV Ultra HD 4K con características inteligentes y colores vivos.",
                "Un reloj inteligente con seguimiento de salud, GPS y un diseño elegante.",
                "Un altavoz Bluetooth portátil con sonido potente y larga duración de batería.",
                "La última consola de juegos con gráficos increíbles y una experiencia inmersiva.",
                "Un ratón inalámbrico diseñado para comodidad y precisión.",
                "Una silla ergonómica perfecta para largas horas en el escritorio.",
                "Un SSD portátil con alta velocidad y almacenamiento amplio para todos tus archivos.",
                "Una cámara de acción con resolución 4K y durabilidad resistente.",
                "Auriculares con cancelación activa de ruido para una experiencia de escucha tranquila.",
                "Un hub para el hogar inteligente que controla todos tus dispositivos inteligentes desde un solo lugar.",
                "Una elegante lámpara de escritorio LED con brillo ajustable y temperatura de color.",
                "Un monitor para juegos con alta tasa de refresco, colores vivos y baja latencia.",
                "Un drone con cámara 4K y características avanzadas de vuelo.",
                "Una tableta de alto rendimiento con pantalla grande y procesamiento rápido.",
                "Un patinete eléctrico con batería de largo alcance y diseño elegante.",
                "Un termostato inteligente que aprende tus preferencias y ahorra energía.",
                "Un cargador inalámbrico para una carga conveniente y rápida de tus dispositivos."
        };

        ArrayList<CustomModel> customModelList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(imagePaths.length);

        for (int i = 0; i < imagePaths.length; i++) {
            StorageReference storageReference = storage.getReferenceFromUrl(imagePaths[i]);

            final int index = i; // Captura el índice en una variable final
            storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                String imageUrl = uri.toString();
                customModelList.add(new CustomModel(imageUrl, titles[index], descriptions[index]));
                latch.countDown(); // Decrementa el contador cuando se obtiene la URL

                if (latch.getCount() == 0) {
                    customModelLiveData.setValue(customModelList);
                }
            }).addOnFailureListener(e -> {
                e.printStackTrace(); // Maneja el error si ocurre
                latch.countDown(); // Decrementa el contador en caso de error
            });
        }
    }
}
