package es.ucm.fdi.gdv.nightmareworks.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
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
        //ALGO EN TRY CATCH
        _canvas.drawColor(0xFF0000FF);
    }

    @Override
    public void drawImage(Image image, int posX, int posY, int widthP, int heightP, int Ix, int Iy, int Iheight, int Iwidth) {
        //ALGO EN TRY CATCH
        Bitmap sprite = ((AndroidImage)image).getImage();
        Rect src = new Rect(Ix,Iy,Iwidth,Iheight);
        Rect dst = new Rect(posX, posY,widthP,heightP);
        if(sprite != null) {
            _canvas.drawBitmap(((AndroidImage) image).getImage(),src,dst,null);
        }
    }

    //Este metodo se llama antes de dibujar la escena
    public void setCanvas(){
        while (!_surface.getHolder().getSurface().isValid())
            ;
        _canvas = _surface.getHolder().lockCanvas();
    }

    //Este método se llama después de dibujar la escena
    public void releaseCanvas(){
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

    Canvas _canvas;
    AssetManager _assetManager;
    SurfaceView _surface;
}
