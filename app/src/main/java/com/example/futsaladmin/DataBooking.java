package com.example.futsaladmin;

public class DataBooking {
    String id;
    String lapangan;
    String status;
    String nama;
    String tanggal;
    String slotjam;
    String jam;
    String telephone;

    public DataBooking() {
    }

    public DataBooking(String id, String lapangan, String status, String nama, String tanggal, String slotjam, String jam, String telephone) {
        this.id = id;
        this.lapangan = lapangan;
        this.status = status;
        this.nama = nama;
        this.tanggal = tanggal;
        this.slotjam = slotjam;
        this.jam = jam;
        this.telephone = telephone;
    }

    public String getSlotjam() {
        return slotjam;
    }

    public void setSlotjam(String slotjam) {
        this.slotjam = slotjam;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
