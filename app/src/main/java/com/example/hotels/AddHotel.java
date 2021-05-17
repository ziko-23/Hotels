package com.example.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class AddHotel extends AppCompatActivity {
    private Button btnSaveHotel;
    private EditText txtName;
    private EditText txtNbrStars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);
        btnSaveHotel = (Button)findViewById(R.id.btnSaveHotel);
        txtNbrStars = (EditText)findViewById(R.id.txtNbrStars);
        txtName = findViewById(R.id.txtName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnSaveHotel.setOnClickListener(v->{
            insertHotel(txtName.getText().toString(),Double.valueOf(txtNbrStars.getText().toString()));
            Intent intent = new Intent(AddHotel.this,HotelsByStars.class);
            intent.putExtra("nbrStars",txtNbrStars.getText().toString());
            startActivity(intent);
        });
    }
    public AtomicReference<Hotel> insertHotel(String name, double nbStars) {
        AtomicReference<Hotel> Hotel = new AtomicReference<Hotel>();
        MainActivity.realm.executeTransaction(transactionRealm -> {
            Hotel result =transactionRealm.createObject(Hotel.class, UUID.randomUUID().toString());
            result.setName(name);
            result.setNbStars(nbStars);
            Hotel.set(result);
        });
        return Hotel;
    }
}