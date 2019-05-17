package com.exacore.gerenciadordeponto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;

public class telaInicial extends AppCompatActivity {

    private static Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setView(this);
    }
}
