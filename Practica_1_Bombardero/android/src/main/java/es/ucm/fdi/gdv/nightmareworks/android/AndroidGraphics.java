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

public class AndroidGraphics implements Graphics{
    public AndroidGraphics(AssetManager assetManager, SurfaceView surface){
        _assetManager = assetManager;
        _surface = surface;
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
        Canvas _canvas = _surface.getHolder().lockCanvas();
        //ALGO EN TRY CATCH
        _canvas.drawColor(color);
        _surface.getHolder().unlockCanvasAndPost(_canvas);
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        Canvas _canvas = _surface.getHolder().lockCanvas();
        //ALGO EN TRY CATCH
        _canvas.drawBitmap(((AndroidImage) image).getImage(), x, y, null);
        _surface.getHolder().unlockCanvasAndPost(_canvas);
    }

    @Override
    public int getWidth() {
        return _surface.getWidth();
    }

    @Override
    public int getHeight() {
        return _surface.getHeight();
    }

    AssetManager _assetManager;
    SurfaceView _surface;
}
