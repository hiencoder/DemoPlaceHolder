package com.example.hiennv.demoplaceholder.model.feed;

import com.google.gson.annotations.SerializedName;

public class New {
    @SerializedName("title")
    private String title;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("caption")
    private String caption;

    @SerializedName("time")
    private String time;

    public New(String title, String imageUrl, String caption, String time) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
