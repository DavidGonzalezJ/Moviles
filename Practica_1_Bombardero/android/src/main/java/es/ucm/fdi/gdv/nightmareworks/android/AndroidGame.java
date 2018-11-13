package es.ucm.fdi.gdv.nightmareworks.android;

import android.content.Context;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

public class AndroidGame implements Game {
    public  AndroidGame(Context context){
        _graphics = new AndroidGraphics(context);
        _input = new AndroidInput(context);
    }
    @Override
    public Graphics getGraphics() {
        return _graphics;
    }

    @Override
    public Input getInput() {
        return _input;
    }
    Graphics _graphics;
    Input _input;
}
