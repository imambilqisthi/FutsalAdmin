package com.example.futsaladmin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertLapanganActivity extends AppCompatActivity {
    EditText ETLapangan,ETStatus;
    Button BtnAddData;
    DatabaseReference Datadb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan);
        ETLapangan = findViewById(R.id.ETLapangan);
        ETStatus = findViewById(R.id.ETStatus);
        BtnAddData = findViewById(R.id.BtnAddData);
        Datadb = FirebaseDatabase.getInstance().getReference().child("Lapangan");
        BtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });
    }
    private void InsertData() {
        String id,lapangan,status;
        id = Datadb.push().getKey();
        lapangan = ETLapangan.getText().toString();
        status =  ETStatus.getText().toString();
        DataLapangan data = new DataLapangan(id,lapangan,status);
        Datadb.child(id).setValue(data);
        Toast.makeText(InsertLapanganActivity.this,"Data Berhasil Diinputkan",Toast.LENGTH_SHORT).show();

    }
}