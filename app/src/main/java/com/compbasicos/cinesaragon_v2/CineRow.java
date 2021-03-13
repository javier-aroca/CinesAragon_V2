package com.compbasicos.cinesaragon_v2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.compbasicos.cinesaragon_v2.adapter.AdapterCines;
import com.compbasicos.cinesaragon_v2.adapter.AdapterPeliculas;
import com.compbasicos.cinesaragon_v2.beans.Cine;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesContract;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesPresenter;
//import com.compbasicos.cinesaragon_v2.lstPeliculas.LstPeliculasPresenter;

import java.util.ArrayList;

public class  CineRow extends AppCompatActivity
        implements  LstCinesContract.View {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

//    private LstPeliculasPresenter lstPeliculasPresenter;
    private LstCinesPresenter lstCinesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Instanciar al Presenter*/
//        lstPeliculasPresenter = new LstPeliculasPresenter(this);
//        lstPeliculasPresenter.getPeliculas();
        lstCinesPresenter = new LstCinesPresenter(this);
        lstCinesPresenter.getCines();
        /*Fin*/


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

    }

    @Override
    public void sucessListCines(ArrayList<Cine> lstCines) {
        // Crear un nuevo adaptador
        adapter = new AdapterCines(lstCines);
        recycler.setAdapter(adapter);
    }

    @Override
    public void failureListCines(String message) {

    }

//    @Override
//    public void sucessListPeliculas(ArrayList<Pelicula> lstPeliculas) {
//        // Crear un nuevo adaptador
//        adapter = new AdapterPeliculas(lstPeliculas);
//        recycler.setAdapter(adapter);
//    }
//
//    @Override
//    public void failureListPeliculas(String message) {
//
//    }
}