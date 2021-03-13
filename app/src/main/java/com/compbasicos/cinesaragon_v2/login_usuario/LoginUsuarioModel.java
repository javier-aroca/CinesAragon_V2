package com.compbasicos.cinesaragon_v2.login_usuario;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import com.compbasicos.cinesaragon_v2.beans.Usuario;
import com.compbasicos.cinesaragon_v2.utils.Post;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginUsuarioModel implements LoginUsuarioContract.Model {
    private ArrayList<Usuario> lstUsuarios;
    private OnLoginUsuarioListener onLoginUsuarioListener;
    @Override
    public void getUsuarioService(final OnLoginUsuarioListener onLoginUsuarioListener,
                               Usuario usuario) {
        this.onLoginUsuarioListener = onLoginUsuarioListener;
        HashMap<String,String> param = new HashMap<>();
        param.put("ACTION", "USUARIO.FIND_LOGIN");
        param.put("LOGIN", usuario.getNombre());
        param.put("PASSWORD", usuario.getPassword());
        //ACTION=USUARIO.LOGIN
        // &EMAIL=prueba@gmail.com
        // &PASSWORD=12345
        TareaSegundoPlano miTarea =
                new TareaSegundoPlano(param);
        //Cambiar URL según IP
        miTarea.execute("http://192.168.0.101:8080/CinesAragonAndroid/Controller");
        //Cambiar URL Según IP
        //42644/RakutenTVAndroid/Controller
    }

    /*Clase ASYNKTASK*/
// HILO ASYNCTASK
    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
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
                lstUsuarios = Usuario.getArrayListFromJSon(result);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if(resp){
                    onLoginUsuarioListener.onFinished(lstUsuarios.get(0));
                }
            }catch (Exception e) {
                onLoginUsuarioListener.onFailure("Fallo:Login Usuario");
            }
        }
    }

}

