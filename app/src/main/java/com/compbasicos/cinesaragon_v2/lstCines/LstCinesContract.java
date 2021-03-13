package com.compbasicos.cinesaragon_v2.lstCines;

import com.compbasicos.cinesaragon_v2.beans.Cine;


import java.util.ArrayList;


public interface LstCinesContract {

    public interface View{
        void sucessListCines(ArrayList<Cine> lstCines);
        void failureListCines(String message);
    }
    public interface Presenter{
        void getCines();
    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstCinesListener{
            void onFinished(ArrayList<Cine> lstCines);
            void onFailure(String error);
        }
        void getCinesService(OnLstCinesListener onLstCinesListener);
    }   
    
}
