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
import com.exacore.gerenciadordeponto.Views.TelaVisualizarBatidas;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Presenter implements InterfaceMVP.Presenter {
    private InterfaceMVP.ViewTelaInicial telaInicial;
    private InterfaceMVP.ViewTelaCadastro telaCadastro;
    private InterfaceMVP.ViewTelaVisualizarBatidas telaViewBatidas;
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
    public void botaoBaterPontoOnClick() {

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
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        Usuario novoUsuario = new Usuario(null, nomeCompleto, dataNascimento, Long.parseLong(PIS));
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
        return nomes;
    }

    @Override
    public void botaobotaoVoltarPrincipalOnClick() {
        telaViewBatidas.navigateToTelaInicial();
    }

    public void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));

        telaCadastro.setDataNascimentoText(meuCalendario.getTime(), sdf.format(meuCalendario.getTime()));
    }
}
