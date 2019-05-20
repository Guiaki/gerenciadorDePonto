package com.exacore.gerenciadordeponto.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exacore.gerenciadordeponto.Models.Batida;
import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.R;

public class TelaMsgSucesso extends AppCompatActivity implements InterfaceMVP.ViewTelaSucesso{

    private static Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_msg_sucesso);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gerenciadorPonto.db", null);
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setDaoMaster(helper);
        presenter.setTelaViewSucesso(this);
        presenter.setCurrentContext(this.getApplicationContext());

        Intent intent = getIntent();
        String principal = intent.getStringExtra("principal");
        String secundario = "";
        if(intent.hasExtra("secundario")){
            secundario = intent.getStringExtra("secundario");
        }
        setTexto(principal, secundario);
        Button botaoVoltarPrincipal = findViewById(R.id.botaoVoltarPrincipalSucesso);
        botaoVoltarPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaobotaoVoltarPrincipalSucessoOnClick();
            }
        });
    }

    @Override
    public void setTexto(String principal, String secundario) {
        TextView textMain = findViewById(R.id.textMain);
        TextView textSecondary = findViewById(R.id.textSecondary);
        textMain.setText(principal);
        if (!secundario.isEmpty()){
            textSecondary.setText(secundario);
            textSecondary.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void navigateToTelaInicial() {
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
}
