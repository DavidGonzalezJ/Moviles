package es.ucm.fdi.gdv.nightmareworks.Logic;

import es.ucm.fdi.gdv.nightmareworks.aninterface.Game;
import es.ucm.fdi.gdv.nightmareworks.aninterface.Image;

public class Screen {

    Screen(Game game){
        _game = game;
    }

    void init(int height, int width, String grid, String gridColor){
        _grid = new Character[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                _grid[i][j] = grid.charAt(i*width+j);
            }
        }
        _gridColor = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                _gridColor[i][j] = (int)gridColor.charAt(i*width+j);
            }
        }
        _sprites = new Sprite[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                Image aux = _game.getImage(_gridColor[i][j]);
                int[] pos = cellToPixel(i,j);
                int imgPos = _grid[i][j].hashCode();
                _sprites[i][j]= new Sprite(aux,imgPos,imgPos%16 * 16,aux.getWidth()/16,aux.getHeight()/16,_game.getGraphics(),pos[0],pos[1],pos[2],pos[2]);
            }
        }
    }

    //Devuelve un array con 3 valores: la posicion x e y en pixeles de una celda y el tamaño de ésta
    private int[] cellToPixel(int row, int column){
        int cellPix = Math.min(_game.getGraphics().getWidth()/_sprites[0].length,_game.getGraphics().getHeight()/_sprites.length);
        int blankHorizontal =  (_game.getGraphics().getWidth() - _sprites[0].length*cellPix)/2;
        int blankVertical = (_game.getGraphics().getHeight() - _sprites.length*cellPix)/2;
        return  new int[]{blankHorizontal + row*cellPix , blankVertical + column*cellPix, cellPix};
    }


    void Clear(){
        _game.getGraphics().clear(0);
    }

    void Draw(){
        for(int i = 0; i < _sprites.length; i++){
            for(int j = 0; j < _sprites[0].length; j++){
                _sprites[i][j].render();
            }
        }
    }

    private Character[][] _grid;
    private int[][] _gridColor;
    private Sprite[][] _sprites;
    private Game _game;
}
