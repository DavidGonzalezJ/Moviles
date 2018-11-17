package es.ucm.fdi.gdv.nightmareworks.aninterface;

import java.util.Stack;
import java.util.Vector;

public interface Game {
    Graphics getGraphics();
    Input getInput();

    void addState(GameState state);

    void popState();

    void addImage(Image img);

    Image getImage(int at);


    void run();
    Stack<GameState> _states = null;
    Vector<Image> _images = null;
}