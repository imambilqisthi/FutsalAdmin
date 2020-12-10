package com.example.futsaladmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DataLapanganActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<DataLapangan> dataLapangan;
    private LapanganAdapter lapanganAdapter;

    DatabaseReference dbref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_lapangan);
        FloatingActionButton floatingActionButton = findViewById(R.id.BtnFloating);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataLapanganActivity.this, InsertLapanganActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataLapangan = new ArrayList<DataLapangan>();
        dbref = FirebaseDatabase.getInstance().getReference().child("Lapangan");
        dbref.addListenerForSingleValueEvent(valueEventListener);
        }
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DataLapangan DtLapangan = dataSnapshot.getValue(DataLapangan.class);
                    dataLapangan.add(DtLapangan);
                }
                lapanganAdapter = new LapanganAdapter(DataLapanganActivity.this, dataLapangan);
                recyclerView.setAdapter(lapanganAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
    };

}