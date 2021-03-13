package com.compbasicos.cinesaragon_v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.compbasicos.cinesaragon_v2.R;
import com.compbasicos.cinesaragon_v2.beans.Cine;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class AdapterCines
        extends
        RecyclerView.Adapter<AdapterCines.CineViewHolder> implements View.OnClickListener{

    private ArrayList<Cine> lstCines;
private View.OnClickListener listener;




    public static class CineViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagenCine;
        public TextView nombreCine;
        public TextView direccionCine; //visitas

        public CineViewHolder(View v) {
            super(v);
            imagenCine = (ImageView) v.findViewById(R.id.imagenCine);
            nombreCine = (TextView) v.findViewById(R.id.nombreCine);
            direccionCine = (TextView) v.findViewById(R.id.direccionCine);
        }
    }

    public AdapterCines(ArrayList<Cine> lstCines) {
        this.lstCines= lstCines;
    }

    @Override
    public CineViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cine_row,
                        viewGroup, false);

        viewGroup.setOnClickListener(this);
        return new CineViewHolder(v);
    }



    @Override
    public void onBindViewHolder(CineViewHolder viewHolder, int posFila) {
        String urlImage = "http://192.168.0.101:8080/CinesAragonAndroid/images/" +
                lstCines.get(posFila).getUrl()+".png";

        Picasso.get().load(urlImage).
                into(viewHolder.imagenCine);

        viewHolder.nombreCine.setText(lstCines.get(posFila).getNombre());
        viewHolder.direccionCine.setText(
                String.valueOf(lstCines.get(posFila).getDireccion()));


        //https://antonioleiva.com/recyclerview-listener/
    }

    @Override
    public int getItemCount() {
        return lstCines.size();
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

}


