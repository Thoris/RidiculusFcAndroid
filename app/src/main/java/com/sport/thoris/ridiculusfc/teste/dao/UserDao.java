package com.sport.thoris.ridiculusfc.teste.dao;

import android.content.Context;

public class UserDao extends BaseDao<User, Integer>{

    public UserDao(Context context) {
        super(context, User.class);
    }

    public void swap(int sourceId, int targetId) {
        int sourceSort = getById(sourceId).getSort();
        int targetSort = getById(targetId).getSort();
        //update( getById(sourceId).setSort(targetSort));
        //update(getById(targetId).setSort(sourceSort));
    }

    @Override
    public int insert(User item) {
        try {
            item.setSort(maxOfFieldItem("sort").getSort() + 1);
        }catch (Exception e){
            item.setSort(1);
            e.printStackTrace();
        }
        return super.insert(item);
    }
}