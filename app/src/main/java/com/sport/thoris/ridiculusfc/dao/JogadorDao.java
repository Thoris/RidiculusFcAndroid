package com.sport.thoris.ridiculusfc.dao;

import android.content.Context;

import com.sport.thoris.ridiculusfc.interfaces.dao.IJogadorDao;
import com.sport.thoris.ridiculusfc.models.Jogador;

public class JogadorDao extends BaseDao<Jogador> implements IJogadorDao {

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