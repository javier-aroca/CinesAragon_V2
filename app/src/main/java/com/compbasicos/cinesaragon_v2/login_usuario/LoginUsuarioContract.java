package com.compbasicos.cinesaragon_v2.login_usuario;
import com.compbasicos.cinesaragon_v2.beans.Usuario;

public interface LoginUsuarioContract {
    public interface View {
        void sucessLogin(Usuario usuario);
        void failureLogin(String message);
    }
    public interface Presenter {
        void getUsuario(Usuario usuario);
    }
    public interface Model {
        /*Programación Reactiva*/
        interface OnLoginUsuarioListener {
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
        void getUsuarioService(OnLoginUsuarioListener onLoginUsuarioListener,
                            Usuario usuario);
    }
}
