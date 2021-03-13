package com.compbasicos.cinesaragon_v2.login_usuario;

import com.compbasicos.cinesaragon_v2.beans.Usuario;

public class LoginUsuarioPresenter implements LoginUsuarioContract.Presenter {
    /*Presenter, tiene que poder hablar con el Modelo
     y desencadenar acciones en la vista*/
    private LoginUsuarioContract.View vista;
    private LoginUsuarioModel modelo;

    public LoginUsuarioPresenter(LoginUsuarioContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginUsuarioModel();
    }

    @Override
    public void getUsuario(Usuario usuario) {
        /*Llamamos a nuestro API*/
        modelo.getUsuarioService(new LoginUsuarioContract.Model.OnLoginUsuarioListener() {
            @Override
            public void onFinished(Usuario usuario) {
                vista.sucessLogin(usuario);
            }

            @Override
            public void onFailure(String error) {
                vista.failureLogin(error);
            }
        }, usuario);
    }
}
