package com.example.wallpapersapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpapersapp.Adapters.WallpaperAdapter;
import com.example.wallpapersapp.Models.WallpaperModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList <WallpaperModel> list = new ArrayList<>();
        list.add(new WallpaperModel(R.drawable.wallpaper1,"Halo Infinite"));
        list.add(new WallpaperModel(R.drawable.wallpaper2,"FireWatch"));
        list.add(new WallpaperModel(R.drawable.wallpaper3,"Assassin"));
        list.add(new WallpaperModel(R.drawable.wallpaper4,"Games"));
        list.add(new WallpaperModel(R.drawable.wallpaper5,"Valorant Jet"));
        list.add(new WallpaperModel(R.drawable.wallpaper6,"Valorant"));
        list.add(new WallpaperModel(R.drawable.wallpaper7,"Forza Horizon 4"));
        list.add(new WallpaperModel(R.drawable.wallpaper8,"Apex Legends"));
        list.add(new WallpaperModel(R.drawable.wallpaper9,"Baymax"));

        WallpaperAdapter wallpaperAdapter = new WallpaperAdapter(list,this);
        recyclerView.setAdapter(wallpaperAdapter);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(linearlayoutManager);

    }
}