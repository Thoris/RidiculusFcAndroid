package com.sport.thoris.ridiculusfc.dao;

import java.lang.reflect.ParameterizedType;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.sport.thoris.ridiculusfc.interfaces.IBaseDao;
import com.sport.thoris.ridiculusfc.interfaces.IEntidade;

public abstract class BaseDAO<T extends IEntidade>  {

    protected Context ctx;

    protected DatabaseHelper getHelper() {
        return DatabaseManager.getInstance().getHelper();
    }

    protected Dao<T, Object> getConnection() {
        return getHelper().getDAO(getEntityClass());
    }

    private Class getEntityClass() {
        ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class) t.getActualTypeArguments()[0];
    }

    public List<T> findAll() {
        try {
            return (List<T>) getHelper().getDAO(getEntityClass()).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public T findByPK(Object id) {
        try {
            return (T) getHelper().getDAO(getEntityClass()).queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createOrUpdate(T obj) {
        try {
            return getHelper().getDAO(getEntityClass()).createOrUpdate(obj).getNumLinesChanged() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public boolean delete(T obj) {
        try {
            return getHelper().getDAO(getEntityClass()).delete(obj) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

}