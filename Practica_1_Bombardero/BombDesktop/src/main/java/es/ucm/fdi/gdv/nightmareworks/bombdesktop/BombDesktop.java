package es.ucm.fdi.gdv.nightmareworks.bombdesktop;

import es.ucm.fdi.gdv.nightmareworks.Desktop.*;

public class BombDesktop {

    public static  void main(String[] args){
        DesktopGame game = new DesktopGame("Bombardero");
        img = (DesktopImage) game.getGraphics().newImage("../Assets/AlaiaFace.png");
        while(true) {
            game.getGraphics().clear(0);
            game.getGraphics().drawImage(img, 10, 10);
        }
    }

    static DesktopImage img;
}
