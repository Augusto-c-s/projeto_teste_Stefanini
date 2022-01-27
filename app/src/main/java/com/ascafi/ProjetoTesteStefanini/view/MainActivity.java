package com.ascafi.ProjetoTesteStefanini.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ascafi.ProjetoTesteStefanini.R;
import com.ascafi.ProjetoTesteStefanini.util.RetrofitCat;

public class MainActivity extends AppCompatActivity {

    private RetrofitCat retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        retrofit = new RetrofitCat(this);
        retrofit.getListOfCatsRetrofit();

    }
}