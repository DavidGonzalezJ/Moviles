package es.ucm.fdi.gdv.nightmareworks.android;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceView;

import es.ucm.fdi.gdv.nightmareworks.Logic.Logic;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.GameState;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

public class AndroidGame implements Game {
    public  AndroidGame(){
    }

    public void init(Context context,SurfaceView surface){
        _graphics = new AndroidGraphics(context.getAssets(), surface);
        _input = new AndroidInput(context);
        //Prueba
        _image = _graphics.newImage("AlaiaFace.png");
    }

    @Override
    public Graphics getGraphics() {
        return _graphics;
    }

    @Override
    public Input getInput() {
        return _input;
    }

    @Override
    public void addImage(Image img) {
        _images.add(img);
    }

    @Override
    public Image getImage(int at) {
        return _images.elementAt(at);
    }

    @Override
    public void run() {
        //Llama al run del estado que tiene en la pila
        //_states.peek().Tick();
        //_states.peek().Render();
        _logica.run();
        //PRUEBA
        ((AndroidGraphics)_graphics).setCanvas();
        _graphics.clear(2);
        ((AndroidGraphics)_graphics).releaseCanvas();
    }

    Graphics _graphics;
    Input _input;
    Image _image;
    Logic _logica;
}
