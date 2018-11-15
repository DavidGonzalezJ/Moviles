package es.ucm.fdi.gdv.nightmareworks.Desktop;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

public class DesktopGame implements Game {

    public DesktopGame(String name){
        _graphics = new DesktopGraphics(name);
        //El input es un action listener
        _input = new DesktopInput();
    }

    @Override
    public Graphics getGraphics() {
        return null;
    }

    @Override
    public Input getInput() {
        return null;
    }

    @Override
    public void run() {

    }

    DesktopGraphics _graphics;
    DesktopInput _input;
}
