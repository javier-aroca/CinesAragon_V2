package com.compbasicos.cinesaragon_v2.beans;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Pelicula {

    private String nombre_pelicula, sinopsis, trailer, reparto, genero, url;
    private int idpelicula, duracion, anyo;

    public Pelicula() {
    }

    public Pelicula(int idpelicula,String nombre_pelicula, String sinopsis, String trailer,int duracion, int anyo, String reparto, String genero, String url) {
        this.nombre_pelicula = nombre_pelicula;
        this.sinopsis = sinopsis;
        this.trailer = trailer;
        this.reparto = reparto;
        this.idpelicula = idpelicula;
        this.duracion = duracion;
        this.anyo = anyo;
        this.genero = genero;
        this.url= url;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //    int idpelicula,
//    String nombre_pelicula,
//    String sinopsis,
//    String trailer,
//    int duracion,
//    int anyo,
//    String reparto,
//    String genero

    @Override
    public String toString() {
        return "Pelicula{"
                + "idpelicula=" + idpelicula
                + ", nombre_pelicula=" + nombre_pelicula
                + ", sinopsis=" + sinopsis
                + ", trailer=" + trailer
                + ", duracion=" + duracion
                + ", anyo=" + anyo
                + ", reparto=" + reparto
                + ", genero=" + genero
                + ", url imagen=" + url
                + '}';
    }

    public static String toCadena(Pelicula pelicula) {
        return "Pelicula{"
                + "id_pelicula=" + pelicula.getIdpelicula() + ", "
                + "nombre_pelicula=" + pelicula.getNombre_pelicula() + ", "
                + "sinopsis=" + pelicula.getSinopsis() + ", "
                + "trailer=" + pelicula.getTrailer() + ", "
                + "duracion=" + pelicula.getDuracion() + ", "
                + "año=" + pelicula.getAnyo()+ ", "
                + "reparto=" + pelicula.getReparto() + ", "
                + "genero=" + pelicula.getGenero()+ ", "
                + "url=" + pelicula.getUrl()
                + '}';
    }

    public static String
    toArrayJSon(ArrayList<Pelicula> peliculas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);

        return resp;
    }

    public static String toObjectJson(Pelicula pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }

    public static ArrayList<Pelicula> getArrayListFromJSon(JSONArray datos){
        ArrayList<Pelicula> lista = null;
        Pelicula pelicula = null;
        try {
            if(datos!=null && datos.length() > 0 ){
                lista = new ArrayList<Pelicula>();
            }
            for (int i = 0; i < datos.length(); i++) {
                JSONObject json_data = datos.getJSONObject(i);
                pelicula = new Pelicula();
                pelicula.setNombre_pelicula(json_data.getString("nombre_pelicula"));
                pelicula.setGenero(json_data.getString("genero"));
                //pelicula.setImagen(R.drawable.angel);
                /*Cargar imágenes desde Servidor*/
                pelicula.setUrl(json_data.getString("url"));
                /*Fin*/
                lista.add(pelicula);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;

    }

}
