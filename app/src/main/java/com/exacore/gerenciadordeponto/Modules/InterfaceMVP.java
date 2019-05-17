package com.exacore.gerenciadordeponto.Modules;

import com.exacore.gerenciadordeponto.Models.DaoSession;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Views.TelaCadastro;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

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
        long getId();
        void setId(long id);
        String getNome();
        void setNome(String nome);
        Date getDataNascimento();
        void setDataNascimento(Date dataNascimento);
        long getPIS();
        void setPIS(long PIS);
    }

    interface ViewTelaInicial{
        void navigateToCadastro();
    }

    interface ViewTelaCadastro{
        void displayDatePickerDialog(int day, int month, int year);
        void setDataNascimentoText(String texto);
    }

    interface Presenter {
        void setTelaInicialView(InterfaceMVP.ViewTelaInicial telaInicial);
        void setTelaCadastroView(TelaCadastro telaCadastro);
        void botaoBaterPontoOnClick();
        void botaoCadastroOnClick();
        void botaoVisualizarBatidasOnClick();
        void openDatePicker();
        void datePickerSetDate(int year, int monthOfYear, int dayOfMonth);
    }
}
