package es.ucm.gdv.holamundo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            AssetManager assetManager = this.getAssets();
            InputStream inputStream = assetManager.open("logo.png");
            _sprite = BitmapFactory.decodeStream(inputStream);
        }
        catch (IOException ioe) {

        }
        _renderView = new MyView(this);
        setContentView(_renderView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        _renderView.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        _renderView.pause();
    }


//Es mejor separar el surfaceview
    class MyView extends SurfaceView implements Runnable {
        public MyView(Context context) {
            super(context);
           // _lastFrameTime = System.nanoTime();
            if (_sprite != null)
                _imageWidth = _sprite.getWidth();
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
        public void run() {
            long lastFrameTime = System.nanoTime();
            SurfaceHolder sh = getHolder(); //Gestor de la surface se conserva todo el rato

            while (_running){
                long currentTime = System.nanoTime();
                long nanoElapsedTime = currentTime - lastFrameTime;
                lastFrameTime = currentTime;
                double elapsedTime = (double) nanoElapsedTime / 1.0e9;

                // Logica
                update(elapsedTime);

                // Render
                while (!sh.getSurface().isValid())
                    ;
                Canvas canvas = getHolder().lockCanvas();
                // Tendría que encerrarse en un Try catch !!
                render(canvas);
                getHolder().unlockCanvasAndPost(canvas);

            }//While principal
        }//Run

        //Ejecuta un paso de lógica
        protected void update(double deltaTime){
            _x += _incX * deltaTime;

            if (_x < 0) {
                _x = -_x;
                _incX *= -1;
            }
            else if (_x > getWidth() - _imageWidth) {
                _x = 2*(getWidth() - _imageWidth) - _x;
                _incX *= -1;
            }
        }
        protected void render(Canvas c){
            if (_sprite != null) {
                c.drawColor(0xFF0000FF);
                c.drawBitmap(_sprite, (int) _x, 100, null);
            }
        }

        double _x = 0;
        int _incX = 50;
        int _imageWidth;
        Thread _runningThread ;

    // Lo marcamos como volatil por que al compilar puede intentar reducir el acceso a memoria e interpretar
    // que siempre está en falso y mantenerlo.
        volatile  boolean _running = false;
}//Cierre de myView

    Bitmap _sprite;
    MyView _renderView;
}
