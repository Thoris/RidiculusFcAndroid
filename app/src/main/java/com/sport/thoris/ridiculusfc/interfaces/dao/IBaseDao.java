package com.sport.thoris.ridiculusfc.interfaces.dao;

import java.util.List;

public interface IBaseDao<T> {

    long insert(T item);

    int deleteById(Object primaryKey) ;

    int update(T item) ;

    T getById(Object id);

    List<T> getAll();

    T maxOfFieldItem(String field) throws Exception;

    T minOfFieldItem(String field) throws Exception;

    List<T> getAll(boolean isAsc) ;

    List<T> getAll(String field, boolean isAsc);


    void insertWithTransaction(final List<T> items) ;

    void createWithTransaction(final List<T> items) ;

    void updateWithTransaction(final List<Object> items) ;
}
