package com.compbasicos.cinesaragon_v2.lstCines;

import android.os.AsyncTask;
import android.util.Log;

import com.compbasicos.cinesaragon_v2.beans.Cine;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesContract;
import com.compbasicos.cinesaragon_v2.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LstCinesModel implements  LstCinesContract.Model{


    private OnLstCinesListener onLstCinesListener;
    private ArrayList<Cine> lstCines;

    @Override
    public void getCinesService(final OnLstCinesListener onLstCinesListener) {
        this.onLstCinesListener = onLstCinesListener;
        HashMap<String,String> param = new HashMap<>();
        param.put("ACTION", "CINE.FIND_ALL");
        com.compbasicos.cinesaragon_v2.lstCines.LstCinesModel.TareaSegundoPlano miTarea = new com.compbasicos.cinesaragon_v2.lstCines.LstCinesModel.TareaSegundoPlano(param);
        miTarea.execute("http://192.168.0.101:8080/CinesAragonAndroid/Controller");
        //http://192.168.43.143:42644/RakutenTVAndroid/
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
                lstCines = Cine.getArrayListFromJSon(result);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if(resp){
                    onLstCinesListener.onFinished(lstCines);
                }
            }catch (Exception e) {
                onLstCinesListener.onFailure("Fallo: Listar Cines");
            }
        }
    }

}

