package es.ucm.fdi.gdv.nightmareworks.Desktop;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;

public class DesktopGraphics extends JFrame implements Graphics {

    public DesktopGraphics(String name){
        super(name);
        //ESTO IGUAL DEBERÏA ENTRAR POR PARÄMETRO
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //IGUAL ESTO VA EN EL MAIN
        int tries = 100;
        while(tries-- > 0){
            try{createBufferStrategy(2); break;}
            catch(Exception e){
            }
        }
        if(tries == 0){//No he podido iniciar el doble buffer
            }

        _bs = getBufferStrategy();
        setVisible(true);
    }

    //GetWidth and GetHeight are implemented by JFrame


    @Override
    public Image newImage(String name) {
        java.awt.Image img;
        Image newImg = null;
        try {
            img = javax.imageio.ImageIO.read(
                    new java.io.File("Java-logo.png"));
            newImg = new DesktopImage(img);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        return newImg;
    }

    @Override
    public void clear(int color) {
        //Puede haber otros colores
        _bs.getDrawGraphics().setColor(Color.BLACK);
        _bs.getDrawGraphics().fillRect(0,0,getWidth(),getHeight());
        //Dispose libera los recursos
        _bs.getDrawGraphics().dispose();
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        DesktopImage desIm = (DesktopImage)image;
        _bs.getDrawGraphics().drawImage(desIm.getImage(),x,y,null);
        _bs.getDrawGraphics().dispose();
    }

    private BufferStrategy _bs;
}
