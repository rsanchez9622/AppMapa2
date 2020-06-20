package com.example.appmapa;

public class Marcador {

    public static double latitud;
    public static double longitud;

    public Marcador (double mLatitud, double mLongitud){
        latitud = mLatitud;
        longitud = mLongitud;

    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
