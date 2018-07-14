package com.sport.thoris.ridiculusfc.services;


import com.sport.thoris.ridiculusfc.interfaces.dao.IBaseDao;
import com.sport.thoris.ridiculusfc.interfaces.services.IBaseService;

import java.util.List;

public abstract class BaseService<T> implements IBaseService<T> {

    protected IBaseDao<T> dao;

    protected IBaseDao<T> getDao(){
        return dao;
    }

    public BaseService(IBaseDao<T> daoObj){
        dao = daoObj;
    }

    public long insert(T item) {
        long id;
        try {
            id = getDao().insert(item);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return id;
    }

    public int deleteById(Object primaryKey) {
        int id;
        try {
            id = getDao().deleteById(primaryKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return id;
    }

    public int update(T item) {
        int id;
        try {
            id = getDao().update(item);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return id;
    }

    public T getById(Object id) {
        try {
            return (T)getDao().getById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<T> getAll() {
        try {
            return getDao().getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public T maxOfFieldItem(String field) throws Exception {
        return (T)getDao().maxOfFieldItem(field);
    }

    public T minOfFieldItem(String field) throws Exception {
        return (T)getDao().minOfFieldItem(field);
    }

    public List<T> getAll(boolean isAsc) {
        try {
            return getDao().getAll(isAsc);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<T> getAll(String field, boolean isAsc) {
        try {
            return getDao().getAll(field, isAsc);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void insertWithTransaction(final List<T> items) {
        try {
            getDao().insertWithTransaction(items);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void createWithTransaction(final List<T> items) {
        try {
            getDao().createWithTransaction(items);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void updateWithTransaction(final List<Object> items) {
        try {
            getDao().updateWithTransaction(items);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
