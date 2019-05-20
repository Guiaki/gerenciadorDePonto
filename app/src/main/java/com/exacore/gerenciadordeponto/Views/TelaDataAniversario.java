package com.exacore.gerenciadordeponto.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.R;

import java.util.ArrayList;
import java.util.List;

public class TelaDataAniversario extends AppCompatActivity implements InterfaceMVP.ViewTelaDataAniversario {
    String letraInicial;
    private static Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_data_aniversario);
        Intent intent = getIntent();
        letraInicial = intent.getStringExtra("letraInicial");

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gerenciadorPonto.db", null);
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setDaoMaster(helper);
        presenter.setTelaDataAniversario(this);
        presenter.setCurrentContext(this.getApplicationContext());
        createButtonList();
    }

    private void createButtonList() {
        for (int i = 1; i < 31; i++) {
            int resID = getResources().getIdentifier("button" + i, "id", getPackageName());
            final Button botao = findViewById(resID);
            botao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onClickBaterPonto(letraInicial, Integer.parseInt(botao.getText().toString()));
                }
            });
        }
    }

    @Override
    public void navigateBaterPonto(List<Usuario> usuarios) {
        Intent intent = new Intent(this, TelaListaUsuarios.class);
        intent.putParcelableArrayListExtra("usuarios", (ArrayList<? extends Parcelable>) usuarios);
        startActivity(intent);
    }
}
