package es.ucm.fdi.gdv.nightmareworks.Logic;

import java.util.ArrayList;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;

public class Logic {

    public Logic(Game game) {
        _game = game;
    }

    public  void init(){
        _states.add(new InitState(_game));
        /*_states.add(new InstructionState(_game));
        _states.add(new DifSelectState(_game));

        //JUEGO CON SUBESTADOS
        _states.add(new Construction(_game));
        _states.add(new gameState(_game));
        _states.add(new collisionState(_game));
        _states.add(new landedState(_game));

        //FIN DE PARTIDA
        _states.add(new endState(_game));*/

    }

    public void run() {
        //Llama a cada estado a su tick, render, present, y hace un sleepsystem.
        _states.get(_currentState).Tick();
        _states.get(_currentState).Render();

        //FALTA EL SYSTEM SLEEP

    }
    public  void nextState(){
        _currentState = (_currentState + 1)%_states.size();
    }
    public  void setState(int state){
        _currentState = (state + 1)%_states.size();
    }
    ArrayList<InterGameState> _states;
    int _currentState;
    Game _game;

}
