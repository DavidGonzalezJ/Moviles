package es.ucm.fdi.gdv.nightmareworks.Logic;

import java.util.List;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.GameState;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

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

    public List<Input.TouchEvent> GetEvents(){
        return _game.getInput().getTouchEvents();
    }

    Screen _screen;
    Game _game;
}
