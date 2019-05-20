package com.exacore.gerenciadordeponto.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.exacore.gerenciadordeponto.Modules.InterfaceMVP;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Batida implements InterfaceMVP.ModelBatida, Parcelable{
    @Id(autoincrement = true)
    private Long id;
    private Date dataBatida;

    private long usuarioId;

    @ToOne(joinProperty = "usuarioId")
    private Usuario usuario;

    protected Batida(Parcel in) {
        id = in.readLong();
        usuarioId = in.readLong();
        usuario = in.readParcelable(Usuario.class.getClassLoader());
    }

    @Generated(hash = 1447901918)
    public Batida(Long id, Date dataBatida, long usuarioId) {
        this.id = id;
        this.dataBatida = dataBatida;
        this.usuarioId = usuarioId;
    }

    @Generated(hash = 1645210012)
    public Batida() {
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1182204652)
    private transient BatidaDao myDao;
    @Generated(hash = 41136015)
    private transient Long usuario__resolvedKey;

    public static final Creator<Batida> CREATOR = new Creator<Batida>() {
        @Override
        public Batida createFromParcel(Parcel in) {
            return new Batida(in);
        }

        @Override
        public Batida[] newArray(int size) {
            return new Batida[size];
        }
    };

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public Date getDataBatida() {
        return this.dataBatida;
    }

    public void setDataBatida(Date dataBatida) {
        this.dataBatida = dataBatida;
    }

    public long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1575739643)
    public Usuario getUsuario() {
        long __key = this.usuarioId;
        if (usuario__resolvedKey == null || !usuario__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UsuarioDao targetDao = daoSession.getUsuarioDao();
            Usuario usuarioNew = targetDao.load(__key);
            synchronized (this) {
                usuario = usuarioNew;
                usuario__resolvedKey = __key;
            }
        }
        return usuario;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 149404408)
    public void setUsuario(@NotNull Usuario usuario) {
        if (usuario == null) {
            throw new DaoException(
                    "To-one property 'usuarioId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.usuario = usuario;
            usuarioId = usuario.getId();
            usuario__resolvedKey = usuarioId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 411527131)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBatidaDao() : null;
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
        dest.writeLong(usuarioId);
        dest.writeParcelable(usuario, flags);
    }
}
