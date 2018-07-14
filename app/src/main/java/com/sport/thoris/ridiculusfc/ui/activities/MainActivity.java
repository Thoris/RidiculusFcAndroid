package com.sport.thoris.ridiculusfc.ui.activities;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sport.thoris.ridiculusfc.R;
import com.sport.thoris.ridiculusfc.dao.DatabaseManager;
import com.sport.thoris.ridiculusfc.dao.JogadorDao;
import com.sport.thoris.ridiculusfc.models.Jogador;
import com.sport.thoris.ridiculusfc.services.JogadorService;
import com.sport.thoris.ridiculusfc.services.ServiceManager;


//https://github.com/codepath/android_guides/wiki/Home/6c236e883cc70912ccdd859173050fc147d409f1


//http://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/


//https://stablekernel.com/using-custom-views-as-menu-items/


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        try {


            Log.e("MAIN_TESTE", "INICIALIZANDO");
            this.deleteDatabase("ridiculus.db");
            Jogador jogador = new Jogador();
            jogador.setNome("thoris");
            //DatabaseManager.init(this);

            ServiceManager.init(this);
            JogadorService jogadorService = JogadorService.getInstance(this);
            Log.e("MAIN_TESTE", "DB INICIADO");
            jogadorService.insert(jogador);
            //JogadorDao.getInstance(this).createOrUpdate(jogador);
            //Jogador entry = JogadorDao.getInstance(this).findAll().get(0);
            //Jogador entry = JogadorDao.getInstance(this).findByPK(10);
            Jogador entry = jogadorService.getById(1);
            Log.e("MAIN_TESTE", "INICIALIZADO");

String data = "";
if (entry == null)
    data = "NULL";
else
    data = entry.getNome();

            AlertDialog ad = new AlertDialog.Builder(this).create();
            ad.setCancelable(false); // This blocks the 'BACK' button
            ad.setMessage(data);
            ad.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            ad.show();
        }
        catch (Exception e){
            Log.e("MAIN_TESTE", "INICIALIZANDO:", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
