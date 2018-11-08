package es.ucm.fdi.gdv.nightmareworks.aninterface;

import java.util.List;

public interface Input {
    class TouchEvent{};
    List<TouchEvent> getTouchEvents();
}
