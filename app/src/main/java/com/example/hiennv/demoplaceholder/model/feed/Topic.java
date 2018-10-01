package com.example.hiennv.demoplaceholder.model.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topic {
    @SerializedName("catergory")
    private String category;

    @SerializedName("data")
    private List<New> data;

    public Topic(String category, List<New> data) {
        this.category = category;
        this.data = data;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<New> getData() {
        return data;
    }

    public void setData(List<New> data) {
        this.data = data;
    }
}
