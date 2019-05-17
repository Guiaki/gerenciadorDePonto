package com.exacore.gerenciadordeponto.Models;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Usuario implements InterfaceMVP.ModelUsuario{
    @Id(autoincrement = true)
    private long id;
    private String nome;
    private Date dataNascimento;
    private long PIS;
    @Generated(hash = 601359280)
    public Usuario(long id, String nome, Date dataNascimento, long PIS) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.PIS = PIS;
    }
    @Generated(hash = 562950751)
    public Usuario() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public long getPIS() {
        return this.PIS;
    }
    public void setPIS(long PIS) {
        this.PIS = PIS;
    }
}
