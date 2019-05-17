package com.exacore.gerenciadordeponto.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.R;

public class TelaVisualizarBatidas extends AppCompatActivity implements InterfaceMVP.ViewTelaVisualizarBatidas{

    private static Presenter presenter;

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

        presenter.loadAllUsers();
    }

    @Override
    public void navigateToTelaInicial() {
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
}
