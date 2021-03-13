package com.compbasicos.cinesaragon_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.compbasicos.cinesaragon_v2.LoginRow;
import com.compbasicos.cinesaragon_v2.R;
import com.compbasicos.cinesaragon_v2.adapter.AdapterCines;
import com.compbasicos.cinesaragon_v2.adapter.AdapterPeliculas;
import com.compbasicos.cinesaragon_v2.beans.Cine;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesContract;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesPresenter;
import com.compbasicos.cinesaragon_v2.lstPeliculas.LstPeliculasContract;
import com.compbasicos.cinesaragon_v2.lstPeliculas.LstPeliculasPresenter;

import java.util.ArrayList;


    public class PeliculaLista extends AppCompatActivity
            implements  LstPeliculasContract.View {

        private RecyclerView recycler;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager lManager;

        //private LstPeliculasPresenter lstPeliculasPresenter;
        private LstPeliculasPresenter lstPeliculasPresenter;
//        private Button btnLogin;
//        private ArrayList<Pelicula> lstPeliculas;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pelicula_lista);
            /*Instanciar al Presenter*/

            lstPeliculasPresenter = new LstPeliculasPresenter(this);
            lstPeliculasPresenter.getPeliculas();

            /*Fin*/


            // Obtener el Recycler
            recycler = (RecyclerView) findViewById(R.id.recicladorPelicula);
            recycler.setHasFixedSize(true);

            // Usar un administrador para LinearLayout
            lManager = new LinearLayoutManager(this);
            recycler.setLayoutManager(lManager);

        }


        @Override
        public void sucessListPeliculas(ArrayList<Pelicula> lstPeliculas) {
            // Crear un nuevo adaptador
           adapter = new AdapterPeliculas(lstPeliculas);
           //this.lstPeliculas=lstPeliculas;

            // por que no funciona?? aqui debería llamar a
          // ((AdapterPeliculas) adapter).setOnClickListener(v -> Toast.makeText(getApplicationContext(),"Seleccion:"+lstPeliculas.get(recycler.getChildAdapterPosition(v)).getNombre_pelicula(),Toast.LENGTH_SHORT).show());;

            recycler.setAdapter(adapter);
           // recycler.setOnClickListener();
        }

        @Override
        public void failureListPeliculas(String message) {

        }
    }
