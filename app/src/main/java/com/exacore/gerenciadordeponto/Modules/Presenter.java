package com.exacore.gerenciadordeponto.Modules;

import android.app.DatePickerDialog;

import com.exacore.gerenciadordeponto.Views.TelaCadastro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Presenter implements InterfaceMVP.Presenter {
    private InterfaceMVP.ViewTelaInicial telaInicial;
    private InterfaceMVP.ViewTelaCadastro telaCadastro;
    private Calendar meuCalendario;

    public Presenter() {
        meuCalendario = Calendar.getInstance();
    }

    @Override
    public void setTelaInicialView(InterfaceMVP.ViewTelaInicial telaInicial) {
        this.telaInicial = telaInicial;
    }

    @Override
    public void setTelaCadastroView(TelaCadastro telaCadastro) {
        this.telaCadastro = telaCadastro;
    }

    @Override
    public void botaoBaterPontoOnClick() {

    }

    @Override
    public void botaoCadastroOnClick() {
        telaInicial.navigateToCadastro();
    }

    @Override
    public void botaoVisualizarBatidasOnClick() {

    }

    @Override
    public void openDatePicker() {
        int year = meuCalendario.get(Calendar.YEAR);
        int month = meuCalendario.get(Calendar.MONTH);
        int day = meuCalendario.get(Calendar.DAY_OF_MONTH);

        telaCadastro.displayDatePickerDialog(day, month, year);
    }

    @Override
    public void datePickerSetDate(int year, int monthOfYear, int dayOfMonth) {
        meuCalendario.set(Calendar.YEAR, year);
        meuCalendario.set(Calendar.MONTH, monthOfYear);
        meuCalendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateLabel();
    }

    public void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));

        telaCadastro.setDataNascimentoText(sdf.format(meuCalendario.getTime()));
    }
}
