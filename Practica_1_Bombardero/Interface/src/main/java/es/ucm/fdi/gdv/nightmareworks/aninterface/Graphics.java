package es.ucm.fdi.gdv.nightmareworks.aninterface;

public interface Graphics {
    Image newImage(String name);
    void clear(int color);
    void drawImage(Image image, int posX, int posY, int widthP, int heightP, int Ix, int Iy, int Iheight, int Iwidth);

    //Ventana
    int getWidth();
    int getHeight();
}
