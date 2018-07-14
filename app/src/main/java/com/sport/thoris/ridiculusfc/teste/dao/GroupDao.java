package com.sport.thoris.ridiculusfc.teste.dao;

import android.content.Context;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GroupDao extends BaseDao<Group, Integer>{

    public GroupDao(Context context) {
        super(context, Group.class);
    }

    public List<Group> getByUserId(int userId){
        try {
            return getDao().queryBuilder().where().eq("user_id", userId).query();
        }catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}