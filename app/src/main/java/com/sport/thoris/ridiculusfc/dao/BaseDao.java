package com.sport.thoris.ridiculusfc.dao;

import java.lang.reflect.ParameterizedType;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.sport.thoris.ridiculusfc.interfaces.dao.IBaseDao;
import com.sport.thoris.ridiculusfc.interfaces.models.IEntidade;

public abstract class BaseDao<T extends IEntidade> implements IBaseDao<T>  {

    private Dao<T, Object> dao;


    protected Context ctx;

    protected DatabaseHelper getHelper() {
        return DatabaseManager.getInstance().getHelper();
    }

    protected Dao<T, Object> getConnection() {

        if (dao == null){
            dao = getHelper().getDAO(getEntityClass());
        }
        return dao;
        //return getHelper().getDAO(getEntityClass());
    }

    private Class getEntityClass() {
        ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class) t.getActualTypeArguments()[0];
    }

    /*
    public List<T> findAll() {
        try {
            return (List<T>) getConnection().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public T findByPK(Object id) {
        try {
            return (T) getConnection().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createOrUpdate(T obj) {
        try {
            return getConnection().createOrUpdate(obj).getNumLinesChanged() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public boolean delete(T obj) {
        try {
            return getConnection().delete(obj) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
*/







    public long insert(T item) {
        long id;
        try {
            id = getConnection().create(item);
        } catch (SQLException e) {
            e.printStackTrace();
            id = -1;
        }
        return id;
    }

    public int deleteById(Object primaryKey) {
        int id;
        try {
            id = getConnection().deleteById(primaryKey);
        } catch (SQLException e) {
            e.printStackTrace();
            id = -1;
        }
        return id;
    }

    public int update(T item) {
        int id;
        try {
            id = getConnection().update(item);
        } catch (SQLException e) {
            e.printStackTrace();
            id = -1;
        }
        return id;
    }

    public T getById(Object id) {
        try {
            return (T)getConnection().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> getAll() {
        try {
            return getConnection().queryBuilder().query();
            //return getConnection().queryBuilder().orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public T maxOfFieldItem(String field) throws Exception {
        return (T)getConnection().queryBuilder().orderBy(field, false).limit(1L).query().get(0);
    }

    public T minOfFieldItem(String field) throws Exception {
        return (T)getHelper().getDAO(getEntityClass()).queryBuilder().orderBy(field, true).limit(1L).query().get(0);
    }

    public List<T> getAll(boolean isAsc) {
        try {
            return getConnection().queryBuilder().orderBy("id", isAsc).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<T> getAll(String field, boolean isAsc) {
        try {
            return getConnection().queryBuilder().orderBy(field, isAsc).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public QueryBuilder<T, Object> getQueryBuilder() {
        return getConnection().queryBuilder();
    }

    public void insertWithTransaction(final List<T> items) {
        try {
            TransactionManager.callInTransaction(getHelper().getConnectionSource(), new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    for (T t : items) {
                        getConnection().create(t);
                    }
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createWithTransaction(final List<T> items) {
        try {
            TransactionManager.callInTransaction(getHelper().getConnectionSource(), new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    for (T t : items) {
                        getConnection().update(t);
                    }
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWithTransaction(final List<Object> items) {
        try {
            TransactionManager.callInTransaction(getHelper().getConnectionSource(), new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    getConnection().deleteIds(items);
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}