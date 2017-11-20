package com.sport.thoris.ridiculusfc.services;

import com.sport.thoris.ridiculusfc.models.Jogador;
import com.sport.thoris.ridiculusfc.models.JogadorTime;
import com.sport.thoris.ridiculusfc.models.Time;

import java.util.List;

/**
 * Created by thoris on 18/11/2017.
 */

public class TimeService {




    public TimeService() {

    }

    public void addJogadorTime(Time time, Jogador jogador, int posicao){


         organizarPosicaoTime(time);
    }

    public void removeJogadorTime(Time time, Jogador jogador, int posicao){



        organizarPosicaoTime(time);
    }

    public void organizarPosicaoTime(Time time){

        List<JogadorTime> jogadores = time.getJogadorList();

        for (int i = 0; i < time.getJogadorList().size(); i++){

            JogadorTime jogador = jogadores.get(i);
            jogador.setPosicaoIncluido( i + 1 );
        }
    }




}
