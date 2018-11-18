package es.ucm.fdi.gdv.nightmareworks.aninterface;

import java.util.List;

public interface Input {

    class TouchEvent{
        public TouchEvent(float _x, float _y, int action) {
            this._x = _x;
            this._y = _y;
            this._action = _action;
        }
        float _x, _y;
        int _action;
        //Action es 0 si DOWN y 1 si UP
    };
    List<TouchEvent> getTouchEvents();
}
