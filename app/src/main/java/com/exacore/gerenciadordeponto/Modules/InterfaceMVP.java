package com.exacore.gerenciadordeponto.Modules;

import android.content.Context;

import com.exacore.gerenciadordeponto.Models.Batida;
import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Views.TelaCadastro;
import com.exacore.gerenciadordeponto.Views.TelaDataAniversario;
import com.exacore.gerenciadordeponto.Views.TelaMsgSucesso;
import com.exacore.gerenciadordeponto.Views.TelaVisualizarBatidas;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface InterfaceMVP {
    interface ModelBatida{
    }

    interface ModelUsuario{
    }

    interface ViewTelaInicial{
        void navigateToCadastro();
        void navigateToVisualizarBatidas();
        void navigateToBaterPonto();
    }

    interface ViewTelaCadastro{
        void displayDatePickerDialog(int day, int month, int year);
        void setDataNascimentoText(Date date, String texto);
        void navigateToTelaInicial();
    }

    interface ViewTelaVisualizarBatidas{
        void navigateToTelaInicial();
    }

    interface ViewTelaSucesso{
        void setTexto(String principal, String secundario);
        void navigateToTelaInicial();
    }

    interface ViewTelaBaterPonto{
    }

    interface ViewTelaDataAniversario {
        void navigateBaterPonto(List<Usuario> usuarios);
        void navigateToTelaInicial();
        void navigateToTelaSucesso(String horaAgora);
    }

    interface ViewTelaListaUsuarios {
    }

    interface Presenter {
        void setTelaInicialView(InterfaceMVP.ViewTelaInicial telaInicial);
        void setTelaCadastroView(TelaCadastro telaCadastro);
        void setTelaVisualizarBatidas(TelaVisualizarBatidas telaViewBatidas);
        void setTelaViewSucesso(TelaMsgSucesso telaViewSucesso);
        void botaoBaterPontoOnClick();
        void botaoCadastroOnClick();
        void botaoVisualizarBatidasOnClick();
        void openDatePicker();
        void datePickerSetDate(int year, int monthOfYear, int dayOfMonth);
        void cadastrarForm(String nomeCompleto, Date dataNascimento, String PIS);
        void setCurrentContext(Context current);
        void setDaoMaster(DaoMaster.DevOpenHelper helper);
        ArrayList<String> loadAllBatidas();
        void botaobotaoVoltarPrincipalOnClick();
        void botaobotaoVoltarPrincipalSucessoOnClick();
        void setTelaDataAniversario(TelaDataAniversario telaDataAniversario);
        void onClickBaterPonto(String letraInicial, int diaAniversario);
    }

}
