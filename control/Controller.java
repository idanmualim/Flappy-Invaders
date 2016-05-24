package control;

import java.util.ArrayList;

import field.GameField;
import spaceobjects.Bullet;
import spaceobjects.SpaceObject;

public class Controller {
    
    private GUI graphicsUserInt;
    private GameField field;
    private boolean inPlay;

    public Controller() {
        inPlay = false;
    }
    
    public void setGUI(GUI gui) {
        graphicsUserInt = gui;
    }
    
    public void updateGUI() {
    	graphicsUserInt.repaint();
    }
    
    public void initField() {
    	field = new GameField(this);
    	inPlay = true;
    }
    
    public void step() {
    	field.step();
    }
    
    public ArrayList<SpaceObject> getObjectList() {
    	return field.getSpaceObjects();
    }
    
    public ArrayList<Bullet> getBulletList() {
    	return field.getPlayerBullets();
    }
    
    public void onPressUp() {
    	field.getPlayer().bounce();
    }
    
    public void onPressSpace() {
    	field.getPlayer().shoot();
    }
    
    public boolean isInPlay() {
    	return inPlay;
    }
}
