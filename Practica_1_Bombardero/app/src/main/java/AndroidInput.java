import android.content.Context;
import android.view.View;

import java.util.List;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Input;

public class AndroidInput extends View implements Input {
    public AndroidInput(Context context){
        super(context);

    }
    @Override
    public List<TouchEvent> getTouchEvents() {
        return null;
    }
}