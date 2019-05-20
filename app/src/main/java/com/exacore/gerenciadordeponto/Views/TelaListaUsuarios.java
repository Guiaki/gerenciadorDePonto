package com.exacore.gerenciadordeponto.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.RecyclerViewAdapterListaUsuarios;
import com.exacore.gerenciadordeponto.Modules.RecyclerViewAdapterVisualizarBatidas;
import com.exacore.gerenciadordeponto.R;

import java.util.List;

public class TelaListaUsuarios extends AppCompatActivity implements InterfaceMVP.ViewTelaListaUsuarios {
    List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_usuarios);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        usuarios = bundle.getParcelableArrayList("usuarios");
        for(Usuario user: usuarios){
            Log.i("TelaListaUsuarios", user.getNome());
        }
        iniciarRecyclerView();
    }

    public void iniciarRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.listaBatidas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gerenciadorPonto.db", null);
        RecyclerViewAdapterListaUsuarios adapter = new RecyclerViewAdapterListaUsuarios(this, usuarios, helper);
        recyclerView.setAdapter(adapter);
    }
}
