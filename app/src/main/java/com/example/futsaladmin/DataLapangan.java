package com.example.futsaladmin;

public class DataLapangan {
    String id;
    String lapangan;
    String status;
    public DataLapangan() {
    }

    public DataLapangan(String id,String lapangan, String status) {
        this.id = id;
        this.lapangan = lapangan;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLapangan() {
        return lapangan;
    }

    public void setLapangan(String lapangan) {
        this.lapangan = lapangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
