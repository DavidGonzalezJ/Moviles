package es.ucm.fdi.gdv.nightmareworks.Desktop;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;

public class DesktopImage implements Image {
    public DesktopImage(java.awt.Image image){
        _image = image;
    }

    //Returns the specific image for desktop
    public java.awt.Image getImage(){
        return  _image;
    }

    @Override
    public int getHeight() {
        return _image.getHeight(null);
    }

    @Override
    public int getWidth() {
        return _image.getWidth(null);
    }

    private java.awt.Image _image;
}
