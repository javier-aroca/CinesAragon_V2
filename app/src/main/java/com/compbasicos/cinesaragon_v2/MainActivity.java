package com.compbasicos.cinesaragon_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.compbasicos.cinesaragon_v2.adapter.AdapterCines;
import com.compbasicos.cinesaragon_v2.adapter.AdapterPeliculas;
import com.compbasicos.cinesaragon_v2.beans.Cine;
import com.compbasicos.cinesaragon_v2.beans.Pelicula;
import com.compbasicos.cinesaragon_v2.login_usuario.LoginUsuarioContract;
import com.compbasicos.cinesaragon_v2.login_usuario.LoginUsuarioPresenter;
import com.compbasicos.cinesaragon_v2.beans.Usuario;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesContract;
import com.compbasicos.cinesaragon_v2.lstCines.LstCinesPresenter;
import com.compbasicos.cinesaragon_v2.lstPeliculas.LstPeliculasPresenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements  LstCinesContract.View {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    //private LstPeliculasPresenter lstPeliculasPresenter;
    private LstCinesPresenter lstCinesPresenter;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Instanciar al Presenter*/

        lstCinesPresenter = new LstCinesPresenter(this);
        lstCinesPresenter.getCines();

        /*Fin*/


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

    }

    @Override
    public void sucessListCines(ArrayList<Cine> lstCines) {
        // Crear un nuevo adaptador
        adapter = new AdapterCines(lstCines);
        recycler.setAdapter(adapter);

        //asignar el boton
        btnLogin = findViewById(R.id.btnGoToLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambioUser = new Intent(getBaseContext(), LoginRow.class);
                //Intent cambioUser = new Intent(getApplicationContext(), LoginFragment.class);
                startActivity(cambioUser);
            }
        });

    }

    @Override
    public void failureListCines(String message) {

    }
}