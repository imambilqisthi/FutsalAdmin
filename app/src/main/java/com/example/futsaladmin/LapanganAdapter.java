package com.example.futsaladmin;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LapanganAdapter extends RecyclerView.Adapter<LapanganAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<DataLapangan> dataLapangan;

    public LapanganAdapter(Context c, ArrayList<DataLapangan> dataLapangan){
        this.context = c;
        this.dataLapangan = dataLapangan;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataLapangan dLapangan = this.dataLapangan.get(position);
        holder.TVlapangan.setText(dLapangan.getLapangan());
        holder.TVstatus.setText(dLapangan.getStatus());
        holder.BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Lapangan").child(dLapangan.getId());
                databaseReference.removeValue();
                Toast.makeText(context,"Data Berhasil Dihapus",Toast.LENGTH_SHORT).show();
            }
        });
        holder.BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,UpdateActivity.class);
                i.putExtra("id",dLapangan.getId());
                i.putExtra("lapangan",dLapangan.getLapangan());
                i.putExtra("status",dLapangan.getStatus());
                v.getContext().startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataLapangan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TVlapangan,TVstatus;
        Button BtnDelete, BtnUpdate;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TVlapangan = itemView.findViewById(R.id.TVlapangan);
            TVstatus = itemView.findViewById(R.id.TVstatus);
            BtnDelete = itemView.findViewById(R.id.BtnDelete);
            BtnUpdate = itemView.findViewById(R.id.BtnUpdate);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
