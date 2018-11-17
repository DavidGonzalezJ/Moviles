package es.ucm.fdi.gdv.nightmareworks.Logic;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.GameState;

public abstract class InterGameState implements GameState {



    InterGameState(Game game){
        _game = game;
    }

    //El tick lo implementa cada estado por separado
    @Override
    public abstract void Tick();

    public abstract void init();

    @Override
    public void Render() {
        _screen.Clear();
        _screen.Draw();
    }

    Screen _screen;
    Game _game;
}
