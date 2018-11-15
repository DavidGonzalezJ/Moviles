package es.ucm.fdi.gdv.nightmareworks.bombandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.graphics.Canvas;

import es.ucm.fdi.gdv.nightmareworks.android.AndroidGame;
import es.ucm.fdi.gdv.nightmareworks.android.AndroidGraphics;

public class BombAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _game = new AndroidGame();
        _gameThread = new gameThread(this);
        _game.init(this, _gameThread);
        _gameThread.init(_game);
        setContentView(_gameThread);
    }

    @Override
    protected void onResume(){
        super.onResume();
        _gameThread.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        _gameThread.pause();
    }
    //CLASE GAME THREAD
    public class gameThread extends SurfaceView implements Runnable{
        public gameThread(Context context){
            super(context);
        }

        public void init(AndroidGame game){
            _game = game;
        }

        public void resume(){
            if(!_running){
                _running = true;
                // Si llamamos al run() no tenemos separado de la hebra de UI.
                // Para crear una hebra necesitamos una clase que herede de Runnable
                _runningThread = new Thread(this);
                _runningThread.start(); //Este método hará sus cosas y vuelve, en paralelo se ejecutará el run.

            }//if !running
        } //resume

        public void pause(){
            _running = false;
            while (true) {
                try {
                    _runningThread.join();
                    break;
                } catch (InterruptedException ie) {

                }//Catch
            }//While

            //El pause y el run estan en hebras diferentes
        }//Pause

        @Override
        public void run(){
            //Tick logica
           while(_running) {
               _game.run();
            }
        }
        AndroidGame _game;
        volatile boolean _running = false;
        Thread _runningThread;
    }//Fin clase GameThread

    AndroidGame _game;
    gameThread _gameThread;
}//Fin clase BombAndroid
