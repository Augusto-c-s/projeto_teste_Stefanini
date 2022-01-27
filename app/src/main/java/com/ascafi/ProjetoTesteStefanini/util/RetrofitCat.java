package com.ascafi.ProjetoTesteStefanini.util;

import android.app.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascafi.ProjetoTesteStefanini.R;
import com.ascafi.ProjetoTesteStefanini.model.CatRepository;
import com.ascafi.ProjetoTesteStefanini.model.ImageItemCat;
import com.ascafi.ProjetoTesteStefanini.model.ItemDataCat;
import com.ascafi.ProjetoTesteStefanini.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCat {

    private RecyclerViewAdapter mAdapter;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutManager;
    private Activity activity;

    public RetrofitCat(MainActivity activity) {
        this.activity = activity;
    }

    public void getListOfCatsRetrofit() {

        Call<CatRepository> call = new RetrofitConfig().getApiService().getPhotos();

        call.enqueue(new Callback<CatRepository>() {
            @Override
            public void onResponse(Call<CatRepository> call, Response<CatRepository> response) {
                ArrayList<ImageItemCat> imageList = new ArrayList<>();

                List<ItemDataCat> dataItems = response.body().getData();

                for (int i = 0; i < dataItems.size(); i++) {
                    final ItemDataCat dataItem = dataItems.get(i);
                    if (dataItem.getImages() != null) {
                        for (int y = 0; y < dataItems.get(i).getImages().size(); y++) {
                            imageList.add(dataItems.get(i).getImages().get(y));
                        }
                    }
                }
                buildRecycleView(imageList);

            }

            @Override
            public void onFailure(Call<CatRepository> call, Throwable throwable) {

            }
        });


    }

    private void buildRecycleView(ArrayList<ImageItemCat> imageItemCats) {
        mRecycler = activity.findViewById(R.id.recycler_view);
        mRecycler.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(activity, 4);
        mAdapter = new RecyclerViewAdapter(imageItemCats);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }
}
