package com.exacore.gerenciadordeponto.Modules;

import android.content.Context;
import android.text.Editable;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Models.DaoSession;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Views.TelaCadastro;
import com.exacore.gerenciadordeponto.Views.TelaMsgSucesso;
import com.exacore.gerenciadordeponto.Views.TelaVisualizarBatidas;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface InterfaceMVP {
    interface ModelBatida{
        long getId();
        void setId(long id);
        Date getDataBatida();
        void setDataBatida(Date dataBatida);
        long getUsuarioId();
        void setUsuarioId(long usuarioId);
        Usuario getUsuario();
        void setUsuario(@NotNull Usuario usuario);
        void delete();
        void refresh();
        void update();
        void __setDaoSession(DaoSession daoSession);
    }

    interface ModelUsuario{
        Long getId();
        void setId(Long id);
        String getNome();
        void setNome(String nome);
        Date getDataNascimento();
        void setDataNascimento(Date dataNascimento);
        long getPIS();
        void setPIS(long PIS);
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
        void navigateToTelaInicial();
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
        ArrayList<String> loadAllUsers();
        void botaobotaoVoltarPrincipalOnClick();
        void botaobotaoVoltarPrincipalSucessoOnClick();
    }
}
