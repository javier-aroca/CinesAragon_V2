package com.compbasicos.cinesaragon_v2.lstCines;

import com.compbasicos.cinesaragon_v2.beans.Cine;


import java.util.ArrayList;

public class LstCinesPresenter implements LstCinesContract.Presenter{

    /*Presenter, tiene que poder hablar con el Modelo, y desencadenar
acciones en la Vista*/
    private LstCinesContract.View vista;
    private LstCinesModel modelo;

    public LstCinesPresenter(LstCinesContract.View vista) {
        this.vista = vista;
        this.modelo = new LstCinesModel();
    }

    @Override
    public void getCines() {
        this.modelo.getCinesService(new LstCinesContract.Model.OnLstCinesListener() {
            @Override
            public void onFinished(ArrayList<Cine> lstCines) {
                vista.sucessListCines(lstCines);
            }

            @Override
            public void onFailure(String error) {
                /*TODO*/
            }
        });
    }

}
