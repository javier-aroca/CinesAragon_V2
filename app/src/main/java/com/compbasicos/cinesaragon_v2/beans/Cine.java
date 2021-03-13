package com.compbasicos.cinesaragon_v2.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cine {

    private int idCine;
    private String nombre, direccion, telefono, url;

    public Cine() {
    }

    public Cine(int idCine, String nombre, String direccion, String telefono, String url) {
        this.idCine = idCine;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Cine{" + "id_cine=" + idCine
                + ", nombre=" + nombre
                + ", direccion=" + direccion
                + ", telefono=" + telefono
                + ", url=" + url
                + '}';
    }

    public static String toCadena(Cine cine) {
        return "Cine{"
                + "id_cine=" + cine.getIdCine() + ", "
                + "nombre=" + cine.getNombre()+ ", "
                + "direccion=" + cine.getDireccion()+ ", "
                + "telefono=" + cine.getTelefono()+ ", "
                + "url=" + cine.getUrl()+ ", "
                + '}';
    }

    public static String
    toArrayJSon(ArrayList<Cine> cines) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(cines);

        return resp;
    }

    public static String toObjectJson(Cine cine) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cine);
        return resp;
    }

    public static ArrayList<Cine> getArrayListFromJSon(JSONArray datos){
        ArrayList<Cine> lista = null;
        Cine cine = null;
        try {
            if(datos!=null && datos.length() > 0 ){
                lista = new ArrayList<Cine>();
            }
            for (int i = 0; i < datos.length(); i++) {
                JSONObject json_data = datos.getJSONObject(i);
                cine = new Cine();
                cine.setNombre(json_data.getString("nombre"));
                cine.setDireccion(json_data.getString("direccion"));
                //cine.setImagen(R.drawable.angel);
                /*Cargar imágenes desde Servidor*/
                cine.setUrl(json_data.getString("url"));
                /*Fin*/
                lista.add(cine);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;

    }

}

