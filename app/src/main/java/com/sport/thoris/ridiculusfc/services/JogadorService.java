package com.sport.thoris.ridiculusfc.services;

import android.content.Context;

import com.sport.thoris.ridiculusfc.dao.JogadorDao;
import com.sport.thoris.ridiculusfc.interfaces.dao.IJogadorDao;
import com.sport.thoris.ridiculusfc.interfaces.services.IJogadorService;
import com.sport.thoris.ridiculusfc.models.Jogador;

public class JogadorService extends BaseService<Jogador> implements IJogadorService{

    protected IJogadorDao getDao(){
        return (IJogadorDao)super.getDao();
    }

    public JogadorService(IJogadorDao dao) {
        super(dao);
    }

    public JogadorService(Context ctx){
        super(JogadorDao.getInstance(ctx));
    }

    private static JogadorService service;

    public static JogadorService getInstance(Context ctx) {
        if(service == null) {
            service = new JogadorService(ctx);
        }
        return service;
    }

}
