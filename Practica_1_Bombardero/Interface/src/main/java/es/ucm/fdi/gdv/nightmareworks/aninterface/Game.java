package es.ucm.fdi.gdv.nightmareworks.aninterface;

public interface Game {
    Graphics getGraphics();
    Input getInput();

    void run();
}