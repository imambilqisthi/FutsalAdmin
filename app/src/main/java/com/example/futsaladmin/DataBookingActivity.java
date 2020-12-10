package com.example.futsaladmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DataBookingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<DataBooking> dataBooking;
    private BookingAdapter bookingAdapter;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_booking);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataBooking = new ArrayList<DataBooking>();
        dbref = FirebaseDatabase.getInstance().getReference().child("Booking");
        dbref.addListenerForSingleValueEvent(valueEventListener);
        }
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DataBooking DtBooking = dataSnapshot.getValue(DataBooking.class);
                    dataBooking.add(DtBooking);

                }
                bookingAdapter = new BookingAdapter(DataBookingActivity.this, dataBooking);
                recyclerView.setAdapter(bookingAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    }
