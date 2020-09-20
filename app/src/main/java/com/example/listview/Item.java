package com.example.listview;

public class Item {
    private String image;
    private String title;
    private String subtitle;
    private String description;
    private String count;

    public Item(String image, String title, String subtitle, String description, String count) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}