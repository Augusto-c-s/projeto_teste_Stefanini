package com.ascafi.ProjetoTesteStefanini.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDataCat {

    @SerializedName("images")
    @Expose
    public List<ImageItemCat> images;

    public ItemDataCat() {

    }

    public List<ImageItemCat> getImages() {
        return images;
    }
}
