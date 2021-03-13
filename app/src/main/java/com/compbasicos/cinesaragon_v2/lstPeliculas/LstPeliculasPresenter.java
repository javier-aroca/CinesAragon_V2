package com.compbasicos.cinesaragon_v2.lstPeliculas;

import java.util.ArrayList;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;

public class LstPeliculasPresenter implements LstPeliculasContract.Presenter{

    /*Presenter, tiene que poder hablar con el Modelo, y desencadenar
acciones en la Vista*/
    private LstPeliculasContract.View vista;
    private LstPeliculasModel modelo;

    public LstPeliculasPresenter(LstPeliculasContract.View vista) {
        this.vista = vista;
        this.modelo = new LstPeliculasModel();
    }

    @Override
    public void getPeliculas() {
        this.modelo.getPeliculasService(new LstPeliculasContract.Model.OnLstPeliculasListener() {
            @Override
            public void onFinished(ArrayList<Pelicula> lstPeliculas) {
                vista.sucessListPeliculas(lstPeliculas);

            }

            @Override
            public void onFailure(String error) {
                /*TODO*/
            }
        });
    }

}
