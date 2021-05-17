package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    public static Realm realm;

    private Button btnAdd;
    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;
    private RatingBar ratingBar4;
    private RatingBar ratingBar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        realm = Realm.getInstance(config);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        ratingBar1 = (RatingBar) findViewById(R.id.ratingBar1);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);
        ratingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        ratingBar5 = (RatingBar) findViewById(R.id.ratingBar5);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ratingBar1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MainActivity.this, HotelsByStars.class);
                    intent.putExtra("nbrStars","1");
                    startActivity(intent);

                }
                return true;
            }
        });
        ratingBar2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MainActivity.this, HotelsByStars.class);
                    intent.putExtra("nbrStars","2");

                    startActivity(intent);


                }
                return true;
            }
        });
        ratingBar3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MainActivity.this, HotelsByStars.class);
                    intent.putExtra("nbrStars","3");

                    startActivity(intent);

                }
                return true;
            }
        });
        ratingBar4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MainActivity.this, HotelsByStars.class);
                    intent.putExtra("nbrStars","4");

                    startActivity(intent);

                }
                return true;
            }
        });
        ratingBar5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MainActivity.this, HotelsByStars.class);
                    intent.putExtra("nbrStars","5");

                    startActivity(intent);

                }
                return true;
            }
        });
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddHotel.class);
            startActivity(intent);
        });
    }


    public List<Hotel> getHotelsByStars(double nbStarts) {
        List<Hotel> list = new ArrayList<>();
        list.addAll(realm.where(Hotel.class).equalTo("nbStars", nbStarts).findAll());
        return list;
    }
}