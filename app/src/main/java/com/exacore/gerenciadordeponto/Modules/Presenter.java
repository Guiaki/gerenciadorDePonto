package com.exacore.gerenciadordeponto.Modules;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.exacore.gerenciadordeponto.Models.DaoMaster;
import com.exacore.gerenciadordeponto.Models.DaoSession;
import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.Models.UsuarioDao;
import com.exacore.gerenciadordeponto.Views.TelaCadastro;
import com.exacore.gerenciadordeponto.Views.TelaDataAniversario;
import com.exacore.gerenciadordeponto.Views.TelaMsgSucesso;
import com.exacore.gerenciadordeponto.Views.TelaVisualizarBatidas;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Presenter implements InterfaceMVP.Presenter {
    private InterfaceMVP.ViewTelaInicial telaInicial;
    private InterfaceMVP.ViewTelaCadastro telaCadastro;
    private InterfaceMVP.ViewTelaVisualizarBatidas telaViewBatidas;
    private InterfaceMVP.ViewTelaSucesso telaSucesso;
    private InterfaceMVP.ViewTelaDataAniversario telaDataAniversario;
    private Calendar meuCalendario;
    private DaoMaster.DevOpenHelper helper;
    private Context currentContext;
    private DaoSession daoSession;

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
    public void setTelaVisualizarBatidas(TelaVisualizarBatidas telaViewBatidas) {
        this.telaViewBatidas = telaViewBatidas;
    }

    @Override
    public void setTelaViewSucesso(TelaMsgSucesso telaViewSucesso) {
        this.telaSucesso = telaViewSucesso;
    }

    @Override
    public void setTelaDataAniversario(TelaDataAniversario telaDataAniversario) {
        this.telaDataAniversario = telaDataAniversario;
    }

    @Override
    public void botaoBaterPontoOnClick() {
        telaInicial.navigateToBaterPonto();
    }

    @Override
    public void botaoCadastroOnClick() {
        telaInicial.navigateToCadastro();
    }

    @Override
    public void botaoVisualizarBatidasOnClick() {
        telaInicial.navigateToVisualizarBatidas();
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

    @Override
    public void cadastrarForm(String nomeCompleto, Date dataNascimento, String PIS) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        cal.setTime(dataNascimento);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int ano = cal.get(Calendar.YEAR);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        Usuario novoUsuario = new Usuario(null, nomeCompleto, dia, mes, ano, Long.parseLong(PIS));
        daoSession.insert(novoUsuario);
        telaCadastro.navigateToTelaInicial();
    }

    @Override
    public void setCurrentContext(Context current) {
        this.currentContext = current;
    }

    @Override
    public void setDaoMaster(DaoMaster.DevOpenHelper helper) {
        this.helper = helper;
    }

    @Override
    public ArrayList<String> loadAllUsers() {
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        List<Usuario> usuarios = daoSession.getUsuarioDao().queryBuilder()
            .orderAsc(UsuarioDao.Properties.Nome)
            .list();
        ArrayList<String> nomes = new ArrayList<String>();
        for(Usuario user: usuarios){
            nomes.add(user.getNome());
        }
        return null;
    }

    @Override
    public void botaobotaoVoltarPrincipalOnClick() {
        telaViewBatidas.navigateToTelaInicial();
    }

    @Override
    public void botaobotaoVoltarPrincipalSucessoOnClick() {
        telaSucesso.navigateToTelaInicial();
    }


    @Override
    public void onClickBaterPonto(String letraInicial, int diaAniversario) {
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        QueryBuilder<Usuario> qb = daoSession.getUsuarioDao().queryBuilder();
        qb.and(UsuarioDao.Properties.DiaNascimento.eq(diaAniversario),
        UsuarioDao.Properties.Nome.like(letraInicial+"%"));
        qb.orderAsc(UsuarioDao.Properties.Nome);
        List<Usuario> usuarios = qb.list();
        telaDataAniversario.navigateBaterPonto(usuarios);
    }

    public void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));

        telaCadastro.setDataNascimentoText(meuCalendario.getTime(), sdf.format(meuCalendario.getTime()));
    }
}
