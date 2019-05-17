package com.exacore.gerenciadordeponto.Models;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.exacore.gerenciadordeponto.Models.Batida;
import com.exacore.gerenciadordeponto.Models.Usuario;

import com.exacore.gerenciadordeponto.Models.BatidaDao;
import com.exacore.gerenciadordeponto.Models.UsuarioDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig batidaDaoConfig;
    private final DaoConfig usuarioDaoConfig;

    private final BatidaDao batidaDao;
    private final UsuarioDao usuarioDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        batidaDaoConfig = daoConfigMap.get(BatidaDao.class).clone();
        batidaDaoConfig.initIdentityScope(type);

        usuarioDaoConfig = daoConfigMap.get(UsuarioDao.class).clone();
        usuarioDaoConfig.initIdentityScope(type);

        batidaDao = new BatidaDao(batidaDaoConfig, this);
        usuarioDao = new UsuarioDao(usuarioDaoConfig, this);

        registerDao(Batida.class, batidaDao);
        registerDao(Usuario.class, usuarioDao);
    }
    
    public void clear() {
        batidaDaoConfig.clearIdentityScope();
        usuarioDaoConfig.clearIdentityScope();
    }

    public BatidaDao getBatidaDao() {
        return batidaDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

}
