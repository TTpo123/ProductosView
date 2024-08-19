package com.equipo3.productosview;

public class CustomModel {

    private String imageUrl; // Cambiado de int a String
    private String title;
    private String desc;

    // Constructor actualizado
    public CustomModel(String imageUrl, String title, String desc) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.desc = desc;
    }

    // Getter y Setter para imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getter y Setter para title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter y Setter para desc
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
