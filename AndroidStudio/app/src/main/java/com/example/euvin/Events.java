package com.example.euvin;

public class Events {
    private String name;
    private String location;
    private String date;
    private String time;
    private String description;
    private String categories;
    private int img;
    private boolean isLiked;

    public Events(String name, String location, String date, String time, String description,String categories, int img, boolean isLiked) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.categories=categories;
        this.img = img;
        this.isLiked = isLiked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void toggleLike() {
        isLiked = !isLiked;
    }
}
