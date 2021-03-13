package com.compbasicos.cinesaragon_v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.compbasicos.cinesaragon_v2.R;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;
import com.squareup.picasso.Picasso;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Random;

public class AdapterPeliculas
        extends
        RecyclerView.Adapter<AdapterPeliculas.PeliculaViewHolder> implements View.OnClickListener {

    private ArrayList<Pelicula> lstPeliculas;
    private View.OnClickListener listener;


    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView genero; //visitas

        public PeliculaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            genero = (TextView) v.findViewById(R.id.genero);
        }
    }

    public AdapterPeliculas(ArrayList<Pelicula> lstPeliculas) {
        this.lstPeliculas= lstPeliculas;
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pelicula_row,
                        viewGroup, false);
        viewGroup.setOnClickListener(this);
        return new PeliculaViewHolder(v);
    }

//    private String randomUrlImages(){
//        Random aleatorio = new Random();
//        int valorX = aleatorio.nextInt(200) + 300;//300-499
//        int valorY = aleatorio.nextInt(200) + 300;
//        return "https://picsum.photos/"+valorX+"/"+valorY+"";
//    }

    @Override
    public void onBindViewHolder(PeliculaViewHolder viewHolder, int posFila) {
        String urlImage = "http://192.168.0.101:8080/CinesAragonAndroid/images/" +
                lstPeliculas.get(posFila).getUrl()+".png";
//        String urlDePrueba =
//                "http://192.168.0.101:8080/RakutenTVAndroid/images/mision_imposible.png";
//        //mision_imposible
//        //viewHolder.imagen.setImageResource(lstPeliculas.get(posFila).getImagen());
////        Picasso.get().load(urlDePrueba).
////                    into(viewHolder.imagen);

        Picasso.get().load(urlImage).
                into(viewHolder.imagen);

        //Picasso.get().load(randomUrlImages()).into(viewHolder.imagen);
        viewHolder.nombre.setText(lstPeliculas.get(posFila).getNombre_pelicula());
        viewHolder.genero.setText("Genero:"+
                String.valueOf(lstPeliculas.get(posFila).getGenero()));
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    @Override
    public int getItemCount() {
        return lstPeliculas.size();
    }
}

