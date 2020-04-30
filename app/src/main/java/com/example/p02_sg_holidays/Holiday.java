package com.example.p02_sg_holidays;

public class Holiday {
    private String name;
    private String date;
    private int imageId;

    public Holiday(String name, String date, int imageId) {
        this.name = name;
        this.date = date;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getImageId() {
        return imageId;
    }
}
