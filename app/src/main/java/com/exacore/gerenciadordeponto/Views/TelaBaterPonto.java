package com.exacore.gerenciadordeponto.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.R;

import java.util.List;

public class TelaBaterPonto extends AppCompatActivity implements InterfaceMVP.ViewTelaBaterPonto {
    List<Button> listaBotoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_bater_ponto);
        createButtonList();
    }

    private void createButtonList() {
        for (int i = 1; i < 27; i++) {
            int resID = getResources().getIdentifier("button" + i, "id", getPackageName());
            Log.i("BaterPonto", "button"+i+" resID: "+resID);
            final Button botao = findViewById(resID);
            botao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TelaBaterPonto.this, botao.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void navigateToTelaInicial() {

    }
}
