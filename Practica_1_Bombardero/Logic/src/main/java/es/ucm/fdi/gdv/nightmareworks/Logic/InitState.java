package es.ucm.fdi.gdv.nightmareworks.Logic;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;

public class InitState extends InterGameState {
    InitState(Game game){
        super(game);
    }

    public void init(){
        _game.getGraphics().newImage("AlaiaFace.png");
        for(int i = 0; i < 16 ; i++) {
            String nombre = "ASCII_";
            nombre += Integer.toString(i);
            _game.addImage(_game.getGraphics().newImage(nombre));
        }

        //Cambia de estado -> le avisa al game de que hay que popear y meter el nuevo estado
    }

    @Override
    public void Tick() {
    }
}
