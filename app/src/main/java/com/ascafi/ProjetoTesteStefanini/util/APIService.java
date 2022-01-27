package com.ascafi.ProjetoTesteStefanini.util;

import com.ascafi.ProjetoTesteStefanini.model.CatRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {

    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("search/?q=cats")
    Call<CatRepository> getPhotos();
}
