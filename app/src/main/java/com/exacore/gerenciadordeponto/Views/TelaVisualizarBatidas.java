package com.exacore.gerenciadordeponto.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.Modules.RecyclerViewAdapterVisualizarBatidas;
import com.exacore.gerenciadordeponto.R;

import java.util.ArrayList;

public class TelaVisualizarBatidas extends AppCompatActivity implements InterfaceMVP.ViewTelaVisualizarBatidas{

    private static Presenter presenter;
    private ArrayList<String> batidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_visualizar_batidas);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gerenciadorPonto.db", null);
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setDaoMaster(helper);
        presenter.setTelaVisualizarBatidas(this);
        presenter.setCurrentContext(this.getApplicationContext());
        batidas = presenter.loadAllBatidas();
        iniciarRecyclerView();

        Button botaoVoltarPrincipal = findViewById(R.id.botaoVoltarPrincipal);
        botaoVoltarPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaobotaoVoltarPrincipalOnClick();
            }
        });
    }

    @Override
    public void navigateToTelaInicial() {
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }

    public void iniciarRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.listaBatidas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterVisualizarBatidas adapter = new RecyclerViewAdapterVisualizarBatidas(this, batidas);
        recyclerView.setAdapter(adapter);
    }
}
