package com.exacore.gerenciadordeponto.Modules;

public class Presenter implements InterfaceMVP.Presenter {
    private InterfaceMVP.ViewTelaInicial telaInicial;

    public Presenter() {
    }

    @Override
    public void setTelaInicialView(InterfaceMVP.ViewTelaInicial telaInicial) {
        this.telaInicial = telaInicial;
    }

    @Override
    public void botaoBaterPontoOnClick() {

    }

    @Override
    public void botaoCadastroOnClick() {

    }

    @Override
    public void botaoVisualizarBatidasOnClick() {

    }
}
