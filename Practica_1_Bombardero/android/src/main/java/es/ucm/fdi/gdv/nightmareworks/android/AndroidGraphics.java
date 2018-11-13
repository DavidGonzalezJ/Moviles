package es.ucm.fdi.gdv.nightmareworks.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

import java.io.IOException;
import java.io.InputStream;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;

public class AndroidGraphics extends SurfaceView implements Graphics{
    public AndroidGraphics(Context context){
        super(context);
        _assetManager = context.getAssets();

    }

    @Override
    //Devuelve null si no carga la imagen
    public Image newImage(String name) {
        InputStream inputStream = null;
        Bitmap sprite = null;
        try {
            inputStream = _assetManager.open(name);
            sprite = BitmapFactory.decodeStream(inputStream);
        }catch (IOException ioe){
            return null;
        }
        finally {
            try {
                inputStream.close();
            }catch (IOException ioe){}
        }
        return new AndroidImage(sprite);
    }

    @Override
    public void clear(int color) {
        Canvas _canvas = getHolder().lockCanvas();
        //ALGO EN TRY CATCH
        _canvas.drawColor(color);
        getHolder().unlockCanvasAndPost(_canvas);
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        Canvas _canvas = getHolder().lockCanvas();
        //ALGO EN TRY CATCH
        _canvas.drawBitmap(((AndroidImage) image).getImage(), x, y, null);
        getHolder().unlockCanvasAndPost(_canvas);
    }

    //GetHeight y GetWidth vienen implementados
    AssetManager _assetManager;
}
