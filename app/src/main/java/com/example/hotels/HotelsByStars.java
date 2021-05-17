package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HotelsByStars extends AppCompatActivity {
    RecyclerView recyclerView;
    public static RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Hotel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_by_stars);
        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent = getIntent();
//        switch (intent.getStringExtra("nbrStars")) {
//            case "1":
//        double n = (/)intent.getStringExtra("");
                data = getHotelsByStars(Double.valueOf(intent.getStringExtra("nbrStars")));
                System.out.println(data);
                mAdapter = new CustomRecyclerAdapter(this, data);
                recyclerView.setAdapter(mAdapter);
//                break;
//            case "2":
//                data = getHotelsByStars(Double.valueOf(intent.getStringExtra("nbrStars")));
//                System.out.println(data);
//                mAdapter = new CustomRecyclerAdapter(this, data);
//                recyclerView.setAdapter(mAdapter);
//                break;
//        }
    }

    public List<Hotel> getHotelsByStars(double nbStarts) {
        List<Hotel> list = new ArrayList<>();
        list.addAll(MainActivity.realm.where(Hotel.class).equalTo("nbStars", nbStarts).findAll());
        return list;
    }
}