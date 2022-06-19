package com.example.tugasrecycleview;

import android.os.Parcel;
import android.os.Parcelable;

public class Olshop implements Parcelable {
    private final String nama;
    private final String deskripsi;
    private final String logo;

    public Olshop(String nama, String deskripsi, String logo) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.logo = logo;
    }

    protected Olshop(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        logo = in.readString();
    }

    public static final Creator<Olshop> CREATOR = new Creator<Olshop>() {
        @Override
        public Olshop createFromParcel(Parcel in) {
            return new Olshop(in);
        }

        @Override
        public Olshop[] newArray(int size) {
            return new Olshop[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(deskripsi);
        dest.writeString(logo);
    }
}
