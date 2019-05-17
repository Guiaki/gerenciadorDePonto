package com.exacore.gerenciadordeponto.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.R;

public class TelaInicial extends AppCompatActivity implements InterfaceMVP.ViewTelaInicial{

    private static Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //Inicializa o presenter caso não esteja inicializado, caso esteja, mantem o uso dele
        //Assim não é criado um novo quando mudado a orientação, por exemplo.
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setTelaInicialView(this);

        //Linka botões com Presenter
        Button botaoBaterPonto = findViewById(R.id.botaoBaterPonto);
        botaoBaterPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaoBaterPontoOnClick();
            }
        });
        Button botaoCadastro = findViewById(R.id.botaoCadastro);
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaoCadastroOnClick();
            }
        });
        Button botaoVisualizarBatidas = findViewById(R.id.botaoVisualizarBatidas);
        botaoVisualizarBatidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaoVisualizarBatidasOnClick();
            }
        });
    }

    @Override
    public void navigateToCadastro() {
        Intent intent = new Intent(this, TelaCadastro.class);
        startActivity(intent);
    }
}
