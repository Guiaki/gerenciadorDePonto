package com.exacore.gerenciadordeponto.Database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

public class GerenciadorDB extends DatabaseOpenHelper {
    public GerenciadorDB(Context context, String name, int version) {
        super(context, name, version);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //TODO Migrations
        switch (oldVersion){
            case 1:
                break;
            case 2:
                break;
        }
    }
}
