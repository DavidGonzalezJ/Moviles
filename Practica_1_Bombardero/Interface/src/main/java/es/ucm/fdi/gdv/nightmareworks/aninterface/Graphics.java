package es.ucm.fdi.gdv.nightmareworks.aninterface;

public interface Graphics {
    Image newImage(String name);
    void clear(int color);
    void drawImage(Image image, int x, int y);

    //Ventana
    int getWidth();
    int getHeight();
}
