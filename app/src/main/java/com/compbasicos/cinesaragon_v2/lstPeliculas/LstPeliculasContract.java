package com.compbasicos.cinesaragon_v2.lstPeliculas;

import java.util.ArrayList;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;


public interface LstPeliculasContract {

    public interface View{
        void sucessListPeliculas(ArrayList<Pelicula> lstPeliculas);
        void failureListPeliculas(String message);
    }
    public interface Presenter{
        void getPeliculas();
    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstPeliculasListener{
            void onFinished(ArrayList<Pelicula> lstPeliculas);
            void onFailure(String error);
        }
        void getPeliculasService(OnLstPeliculasListener onLstPeliculasListener);
    }   
    
}
