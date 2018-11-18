package es.ucm.fdi.gdv.nightmareworks.android;

import android.app.Notification;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

public class AndroidInput implements Input, View.OnTouchListener {
    public AndroidInput(){
    }
    @Override
    public List<TouchEvent> getTouchEvents() {
        synchronized (this){
            List<TouchEvent> aux = new ArrayList<TouchEvent>(_events);
            _events.clear();
            return aux;
        }
    }//GetTouchEvents

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_POINTER_UP){
            //Nos aseguramos que solo un hilo toca la variable
            synchronized (this){
                _events.add(new TouchEvent(motionEvent.getX(), motionEvent.getY(), action));
            }
            return  true;
        }
        return false;
    }//OnTouch

    List<TouchEvent> _events;

}//Class AndroidInput