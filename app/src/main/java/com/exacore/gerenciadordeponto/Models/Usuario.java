package com.exacore.gerenciadordeponto.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Usuario implements InterfaceMVP.ModelUsuario, Parcelable {
    @Id(autoincrement = true)
    private Long id;
    private String nome;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    private long PIS;
    @Generated(hash = 47348212)
    public Usuario(Long id, String nome, int diaNascimento, int mesNascimento,
            int anoNascimento, long PIS) {
        this.id = id;
        this.nome = nome;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.PIS = PIS;
    }
    @Generated(hash = 562950751)
    public Usuario() {
    }

    protected Usuario(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        nome = in.readString();
        diaNascimento = in.readInt();
        mesNascimento = in.readInt();
        anoNascimento = in.readInt();
        PIS = in.readLong();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDiaNascimento() {
        return this.diaNascimento;
    }
    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }
    public int getMesNascimento() {
        return this.mesNascimento;
    }
    public void setMesNascimento(int mesNascimento) {
        this.mesNascimento = mesNascimento;
    }
    public int getAnoNascimento() {
        return this.anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    public long getPIS() {
        return this.PIS;
    }
    public void setPIS(long PIS) {
        this.PIS = PIS;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(nome);
        dest.writeInt(diaNascimento);
        dest.writeInt(mesNascimento);
        dest.writeInt(anoNascimento);
        dest.writeLong(PIS);
    }
}
