package es.ucm.fdi.gdv.nightmareworks.Logic;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Graphics;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;

public class Sprite {
    Sprite(Image image, int x, int y, int width, int height, Graphics graphics, int posX, int posY, int cellH, int cellW){
        _x = x; _y = y;
        _width = width; _height = height;
        _image = image;
        _graphics = graphics;
        _posX = posX; _posY = posY; _cellW = cellW; _cellH = cellH;
    }

    void render(){
        _graphics.drawImage(_image,_posX,_posY,_cellW,_cellH,_x,_y,_height,_width);
    }

    int _x, _y, _width, _height;
    int _posX, _posY, _cellW, _cellH;
    Image _image;
    Graphics _graphics;
}
