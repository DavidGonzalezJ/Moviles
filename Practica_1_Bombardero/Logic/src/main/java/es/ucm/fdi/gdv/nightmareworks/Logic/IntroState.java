package es.ucm.fdi.gdv.nightmareworks.Logic;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;

public class IntroState extends InterGameState {

    IntroState(Game game){
        super(game);
    }

    @Override
    public void Tick() {
        //Espera a que haya una pulsación para cambiar de estado
    }

    public void init(){


    }

    public void setScreen(int h, int w, String grid, String colors) {
        _screen = new Screen(_game);
        _screen.init(h, w, grid, colors);
    }
}
