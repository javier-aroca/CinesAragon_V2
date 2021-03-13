package com.compbasicos.cinesaragon_v2.lstPeliculas;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;
import com.compbasicos.cinesaragon_v2.utils.Post;

public class LstPeliculasModel implements  LstPeliculasContract.Model{


    private OnLstPeliculasListener onLstPeliculasListener;
    private ArrayList<Pelicula> lstPeliculas;

    @Override
    public void getPeliculasService(final OnLstPeliculasListener onLstPeliculasListener) {
        this.onLstPeliculasListener = onLstPeliculasListener;
        HashMap<String,String> param = new HashMap<>();
        param.put("ACTION", "PELICULA.FIND_ALL");
        TareaSegundoPlano miTarea = new TareaSegundoPlano(param);
        miTarea.execute("http://192.168.0.101:8080/CinesAragonAndroid/Controller");

    }

    /*CLASE ASYNCTASK*/
    // HILO ASYNCTASK
    class TareaSegundoPlano extends AsyncTask<String, Integer,
            Boolean> {
        private HashMap<String, String> parametros = null;
        public TareaSegundoPlano( HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean  doInBackground(String... params) {
            String url_select = params[0];
            try {
                Post post = new Post();
                JSONArray result = post.getServerDataPost(parametros,url_select);
                lstPeliculas = Pelicula.getArrayListFromJSon(result);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if(resp){
                    onLstPeliculasListener.onFinished(lstPeliculas);
                }
            }catch (Exception e) {
                onLstPeliculasListener.onFailure("Fallo: Listar Películas");
            }
        }
    }

}
