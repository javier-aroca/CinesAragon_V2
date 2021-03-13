package com.compbasicos.cinesaragon_v2.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    private String nombre, password;
    private int idUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String password, int idUsuario) {
        this.nombre = nombre;
        this.password = password;
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }



    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario
                + ", nombre=" + nombre
                + ", password=" + password + '}';
    }

    public static String toCadena(Usuario usuario) {
        return "Usuario{"
                + "idUsuario=" + usuario.getIdUsuario() + ", "
                + "nombre=" + usuario.getNombre() + ", "
                + "password=" + usuario.getPassword()
                + '}';
    }

    public static String
    toArrayJSon(ArrayList<Usuario> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);

        return resp;
    }

    public static String toObjectJson(Usuario usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(usuario);
        return resp;
    }

    public static ArrayList<Usuario> getArrayListFromJSon(JSONArray datos){
        ArrayList<Usuario> lista = null;
        Usuario usuario = null;
        try {
            if(datos!=null && datos.length() > 0 ){
                lista = new ArrayList<Usuario>();
            }
            for (int i = 0; i < datos.length(); i++) {
                JSONObject json_data = datos.getJSONObject(i);
                usuario = new Usuario();
                usuario.setNombre(json_data.getString("nombre"));
                usuario.setPassword(json_data.getString("password"));

                /*Fin*/
                lista.add(usuario);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;

    }

}
