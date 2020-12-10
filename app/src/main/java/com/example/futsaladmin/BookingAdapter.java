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

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder>  {
    private Context context;
    private ArrayList<DataBooking> dataBooking;

    public BookingAdapter(Context c, ArrayList<DataBooking> dataBooking){
        this.context = c;
        this.dataBooking = dataBooking;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.databooking_list,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataBooking dBooking = this.dataBooking.get(position);
        holder.TVlapangan.setText(dBooking.getLapangan());
        holder.TVstatus.setText(dBooking.getStatus());
        holder.TVnama.setText(dBooking.getNama());
        holder.TVtanggal.setText(dBooking.getTanggal());
        holder.TVslot.setText(dBooking.getSlotjam());
        holder.TVjam.setText(dBooking.getJam());
        holder.TVTelpone.setText(dBooking.getTelephone());
        holder.BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Booking").child(dBooking.getId());
                databaseReference.removeValue();
                Toast.makeText(context,"Data Berhasil Dihapus",Toast.LENGTH_SHORT).show();
            }
        });
        /*holder.BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DataBookingActivity.class);
                i.putExtra("id",dBooking.getId());
                i.putExtra("lapangan",dBooking.getLapangan());
                i.putExtra("status",dBooking.getStatus());
                i.putExtra("nama",dBooking.getNama());
                i.putExtra("tanggal",dBooking.getTanggal());
                i.putExtra("slotjam",dBooking.getSlotjam());
                i.putExtra("jam",dBooking.getJam());
                i.putExtra("telephone",dBooking.getNama());
                v.getContext().startActivity(i);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return dataBooking.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TVlapangan,TVstatus,TVnama,TVtanggal,TVslot,TVjam,TVTelpone;
        Button BtnDelete, BtnUpdate;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TVlapangan = itemView.findViewById(R.id.TVlapangan);
            TVstatus = itemView.findViewById(R.id.TVstatus);
            TVnama = itemView.findViewById(R.id.TVnama);
            TVtanggal = itemView.findViewById(R.id.TVtanggal);
            TVslot = itemView.findViewById(R.id.TVslot);
            TVjam = itemView.findViewById(R.id.TVjam);
            TVTelpone= itemView.findViewById(R.id.TVtelpone);
            BtnDelete = itemView.findViewById(R.id.BtnDelete);
            BtnUpdate = itemView.findViewById(R.id.BtnUpdate);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
