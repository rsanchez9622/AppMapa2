package com.example.appmapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText textLat;
    EditText textLong;
    TextView text;
    Button botonBuscar, botonMarcador;
    Marcador newMarcador;
    ArrayList<Marcador> Marcadores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLat = (EditText) findViewById(R.id.textLat);
        textLong = (EditText) findViewById(R.id.textLong);
        botonMarcador = (Button) findViewById(R.id.botonMarcador);
        botonBuscar = (Button) findViewById(R.id.botonBuscar);
        text = (TextView) findViewById(R.id.textView3);
        Marcadores= new ArrayList<>();
        cantidad();

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lorearMapa();

            }
        });
        botonMarcador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AñadirMarcador();

            }
        });

    }
    public void lorearMapa() {
        /*double latitud = Double.parseDouble(textLat.getText().toString());
          double longitud = Double.parseDouble(textLong.getText().toString());

          Mapita.lat = latitud;
          Mapita.lon = longitud;

         */

        Intent i = new Intent(this, Mapita.class);
        Mapita.setMarcadores(Marcadores);
        startActivity(i);

      }
      public void AñadirMarcador(){
          double latitud = Double.parseDouble(textLat.getText().toString());
          double longitud = Double.parseDouble(textLong.getText().toString());

          /*Mapita.lat = latitud;
          Mapita.lon = longitud;*/
         newMarcador = new Marcador(latitud, longitud);
         Marcadores.add(newMarcador);
         cantidad();

      }

      public void cantidad(){
        if (Marcadores.isEmpty()){
            text.setText("no tienes marcadores");

        }else{
            text.setText("tienes" + Marcadores.size() + "marcadores");

          }
      }
}
