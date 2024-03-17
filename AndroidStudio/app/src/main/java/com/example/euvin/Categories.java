package com.example.euvin;

public class Categories {
    private String name;
    private int img;
    private boolean isLiked;

    public Categories(String name, int img, boolean isLiked) {
        this.name = name;
        this.img = img;
        this.isLiked = isLiked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
