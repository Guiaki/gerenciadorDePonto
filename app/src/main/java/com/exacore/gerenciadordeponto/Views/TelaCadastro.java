package com.exacore.gerenciadordeponto.Views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;
import com.exacore.gerenciadordeponto.Modules.Presenter;
import com.exacore.gerenciadordeponto.R;

import java.util.Date;

public class TelaCadastro extends AppCompatActivity implements InterfaceMVP.ViewTelaCadastro{
    private InterfaceMVP.Presenter presenter;
    DatePickerDialog.OnDateSetListener dateSetListener;
    EditText editDataNascimento;
    EditText editNomeCompleto;
    EditText editPIS;
    Date dataFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gerenciadorPonto.db", null);
        if(presenter == null){
            presenter = new Presenter();
        }
        presenter.setDaoMaster(helper);
        presenter.setTelaCadastroView(this);
        presenter.setCurrentContext(this.getApplicationContext());

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                presenter.datePickerSetDate(year, month, dayOfMonth);
            }
        };

        editDataNascimento = findViewById(R.id.editDataNascimento);
        editDataNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.openDatePicker();
            }
        });
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        editPIS = findViewById(R.id.editPIS);
        Button botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.cadastrarForm(editNomeCompleto.getText().toString(), dataFinal, editPIS.getText().toString());
            }
        });
    }

    @Override
    public void displayDatePickerDialog(int day, int month, int year){
        DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public void setDataNascimentoText(Date date, String texto) {
        this.dataFinal = date;
        editDataNascimento.setText(texto);
    }

    @Override
    public void navigateToTelaInicial() {
        Intent intent = new Intent(this, TelaMsgSucesso.class);
        intent.putExtra("principal", "Cadastro realizado com sucesso!");
        startActivity(intent);
    }
}
