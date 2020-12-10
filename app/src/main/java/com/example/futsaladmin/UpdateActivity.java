package com.example.futsaladmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {
    EditText ETLapangan,ETStatus;
    Button BtnUpdate;
    String id,lapangan,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ETLapangan = findViewById(R.id.ETLapangan);
        ETStatus = findViewById(R.id.ETStatus);
        BtnUpdate = findViewById(R.id.BUpdate);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        lapangan = intent.getStringExtra("lapangan");
        status = intent.getStringExtra("status");

        ETLapangan.setText(lapangan);
        ETStatus.setText(status);

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Lapangan").child(id);
                String ulapangan, ustatus;
                ulapangan = ETLapangan.getText().toString();
                ustatus = ETStatus.getText().toString();
                DataLapangan dataLapangan = new DataLapangan(id,ulapangan,ustatus);
                databaseReference.setValue(dataLapangan);
                Toast.makeText(UpdateActivity.this,"Data Berhasil DiUpdate",Toast.LENGTH_SHORT).show();

            }
        });
    }
}