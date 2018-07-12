package com.sport.thoris.ridiculusfc.interfaces;

import java.util.List;

public interface IBaseDao<T> {

    List<T> findAll() ;

    T findByPK(Object id) ;

    boolean createOrUpdate(T obj);

    boolean delete(T obj);
}
