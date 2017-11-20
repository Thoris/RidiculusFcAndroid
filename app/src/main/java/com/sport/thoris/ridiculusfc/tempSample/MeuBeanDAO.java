package com.sport.thoris.ridiculusfc.tempSample;

import android.content.Context;

public class MeuBeanDAO extends BaseDAO<MeuBean> {

    private static MeuBeanDAO dao;

    public static MeuBeanDAO getInstance(Context ctx) {
        if(dao == null) {
            dao = new MeuBeanDAO(ctx);
        }
        return dao;
    }

    private MeuBeanDAO(Context ctx) {
        super();
        super.ctx = ctx;
    }
}


/*
DatabaseManager.init(this);
MeuBeanDAO.getInstance(context).createOrUpdate(meuBean);
*/