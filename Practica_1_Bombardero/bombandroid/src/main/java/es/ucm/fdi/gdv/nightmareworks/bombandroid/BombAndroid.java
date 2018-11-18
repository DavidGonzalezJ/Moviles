package es.ucm.fdi.gdv.nightmareworks.bombandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import es.ucm.fdi.gdv.nightmareworks.android.AndroidGame;

public class BombAndroid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pantalla completa
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Se inicializa el hilo del juego
        _game = new AndroidGame();
        _gameThread = new gameThread(this);
        _game.init(this, _gameThread);

        //Suscribe el input al Surfaceview
        _gameThread.setOnTouchListener((View.OnTouchListener) _game.getInput());

        setContentView(_gameThread);

    }//OnCreate

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

        //Inicializa el hilo
        public void resume(){
            if(!_running){
                _running = true;
                _runningThread = new Thread(this);
                _runningThread.start();
            }//if !running
        } //resume

        //Cierra el hilo
        public void pause(){
            _running = false;
            while (true) {
                try {
                    _runningThread.join();
                    break;
                } catch (InterruptedException ie) {

                }//Catch
            }//While
        }//Pause

        @Override
        public void run(){
            //Tick logica
           while(_running) {
               _game.run();
            }
        }
        volatile boolean _running = false;
        Thread _runningThread;
    }//Fin clase GameThread

    AndroidGame _game;
    gameThread _gameThread;
}//Fin clase BombAndroid
