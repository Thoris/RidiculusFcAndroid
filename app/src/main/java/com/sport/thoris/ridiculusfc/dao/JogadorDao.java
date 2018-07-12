package com.sport.thoris.ridiculusfc.dao;

import android.content.Context;

import com.sport.thoris.ridiculusfc.interfaces.IJogadorDao;
import com.sport.thoris.ridiculusfc.models.ModelBase;

public class JogadorDao extends BaseDAO<ModelBase> implements IJogadorDao {

    private static JogadorDao dao;

    public static JogadorDao getInstance(Context ctx) {
        if(dao == null) {
            dao = new JogadorDao(ctx);
        }
        return dao;
    }

    private JogadorDao(Context ctx) {
        super();
        super.ctx = ctx;
    }
}


//Adicionar na primeira activity
//DatabaseManager.init(this);
//JogadorDao.getInstance(context).createOrUpdate(modelBase);