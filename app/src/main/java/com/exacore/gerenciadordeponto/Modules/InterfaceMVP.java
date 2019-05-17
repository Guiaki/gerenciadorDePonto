package com.exacore.gerenciadordeponto.Modules;

import com.exacore.gerenciadordeponto.Models.DaoSession;
import com.exacore.gerenciadordeponto.Models.Usuario;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

public interface InterfaceMVP {
    public interface ModelBatida{
        public long getId();
        public void setId(long id);
        public Date getDataBatida();
        public void setDataBatida(Date dataBatida);
        public long getUsuarioId();
        public void setUsuarioId(long usuarioId);
        public Usuario getUsuario();
        public void setUsuario(@NotNull Usuario usuario);
        public void delete();
        public void refresh();
        public void update();
        public void __setDaoSession(DaoSession daoSession);
    }

    public interface ModelUsuario{
        public long getId();
        public void setId(long id);
        public String getNome();
        public void setNome(String nome);
        public Date getDataNascimento();
        public void setDataNascimento(Date dataNascimento);
        public long getPIS();
        public void setPIS(long PIS);
    }

    public interface ViewTelaInicial{

    }

    public interface Presenter {
        void setTelaInicialView(InterfaceMVP.ViewTelaInicial telaInicial);
        void botaoBaterPontoOnClick();
        void botaoCadastroOnClick();
        void botaoVisualizarBatidasOnClick();
    }
}
