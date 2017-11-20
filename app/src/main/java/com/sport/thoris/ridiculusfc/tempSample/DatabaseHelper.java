package com.sport.thoris.ridiculusfc.tempSample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    //nome do arquivo do database
    private static final String DATABASE_FILE_NAME = "meu_database.db";

    // sempre que voce mudar objetos em seu database incremente a versao
    private static final int DATABASE_VERSION = 1;

    private Map<Class, Dao<IEntidade, Object>> daos = new HashMap<Class, Dao<IEntidade, Object>>();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {

            Log.i(DatabaseHelper.class.getName(), "onCreate Database");

            Log.i(DatabaseHelper.class.getName(), "Create table MeuBean");
            TableUtils.createTable(connectionSource, MeuBean.class);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            List<String> allSql = new ArrayList<String>();
            switch (oldVersion) {
                case 1:

            }

            for (String sql : allSql) {
                db.execSQL(sql);
            }
        } catch (android.database.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }

    }

    public <T> Dao<T, Object> getDAO(Class<T> entidadeClass) {
        Dao<IEntidade, Object> dao = null;
        if (daos.get(entidadeClass) == null) {
            try {
                dao = getDao(entidadeClass);
            } catch (SQLException e) {
                Log.e(DatabaseHelper.class.getName(), "exception during getDAO", e);
                throw new RuntimeException(e);
            }
            daos.put(entidadeClass, dao);
        }

        return (Dao<T, Object>) daos.get(entidadeClass);
    }

}