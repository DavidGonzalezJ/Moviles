package es.ucm.fdi.gdv.nightmareworks.bombandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.ucm.fdi.gdv.nightmareworks.android.AndroidGame;
import es.ucm.fdi.gdv.nightmareworks.android.AndroidGraphics;

public class gameThread extends SurfaceView implements Runnable{
    public gameThread(Context context, AndroidGame game){
        //Recibe el game por parametro y
        super(context);
        _game = game;
    }

    @Override
    public void run(){
        _game.run();
    //llama al run del game en este run
    }
    AndroidGame _game;
    volatile boolean _running = false;
}

public class BombAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _game = new AndroidGame(this);
        setContentView((AndroidGraphics)_game.getGraphics());
    }
    AndroidGame _game;
}
