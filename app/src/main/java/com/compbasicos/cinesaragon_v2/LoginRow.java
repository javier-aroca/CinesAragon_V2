package com.compbasicos.cinesaragon_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.compbasicos.cinesaragon_v2.beans.Usuario;
import com.compbasicos.cinesaragon_v2.login_usuario.LoginUsuarioContract;
import com.compbasicos.cinesaragon_v2.login_usuario.LoginUsuarioPresenter;

import java.util.ArrayList;

public class LoginRow
        extends AppCompatActivity
        implements LoginUsuarioContract.View {

    private EditText edtUsuario;
    private EditText edtPass;
    private Button btnLogin;
    private LoginUsuarioPresenter loginUsuarioPresenter;
    private ArrayList<Usuario> lstUsuarios;
    private String nombre;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fragment);
        /*Instanciar Presenter*/
        loginUsuarioPresenter = new LoginUsuarioPresenter(this);
        //lstUsuariosPresenter.getUsuarios();
        /*Fin*/
        /*Declaramos objetos del layout*/
        initComponents();
        /*Fin*/
        /*Cargamos SharedPreferences*/
        //cargarPreferencias();
        /*Fin*/
        /*Accion al pulsar el boton Login*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre =edtUsuario.getText().toString();
                password =edtPass.getText().toString();
                Usuario usuario = new Usuario();
                usuario.setNombre("arocaja");
                usuario.setPassword("1234");
//                usuario.setNombre(nombre);
//                usuario.setPassword(password);
                loginUsuarioPresenter.getUsuario(usuario);
            }
        });
    }
    /*Sugerencia: Butterknife Android*/
    private void initComponents(){
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
    /*Fin*/
    @Override
    public void sucessLogin(Usuario usuario) {
        Toast.makeText(this, "Bienvenido=" +
                usuario.getNombre(), Toast.LENGTH_LONG).show();
        /*Intent intent = new Intent(getBaseContext(), ListaPeliculas.class);
        startActivity(intent);*/
        Intent intent = new Intent(getBaseContext(), PeliculaLista.class);
        startActivity(intent);
    }
    @Override
    public void failureLogin(String message) {
//        Toast.makeText(this, message,
//                Toast.LENGTH_LONG).show();
    }
}




