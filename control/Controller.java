package control;

import java.util.ArrayList;

import field.GameField;
import spaceobjects.Bullet;
import spaceobjects.Explosion;
import spaceobjects.SpaceObject;
import spaceobjects.Star;

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
    
    public GUI getGUI() {
    	return graphicsUserInt;
    }
    
    public void updateGUI() {
    	graphicsUserInt.repaint();
    }
    
    public void initField() {
    	graphicsUserInt.requestFocusInWindow();
    	field = new GameField(this);
    	inPlay = true;
    }
    
    public void onGameOver() {
    	inPlay = false;
    	int arg1 = field.getScore();
    	int arg2 = field.getShipsDestroyed();
    	int arg3 = 0;
    	if(field.getShotsFired() != 0)
    		arg3 = (int)(arg2 * 100.0 / field.getShotsFired());
    	double arg4 = ((int)((field.getTime() / 60.0) * 100)) / 100.0;
    	graphicsUserInt.displayGameOver(arg1, arg2, arg3, arg4);
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
    
    public ArrayList<Star> getStarList() {
    	return field.getStars();
    }
    
    public ArrayList<Explosion> getExplosionList() {
        return field.getExplosions();
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
    
    public GameField getField() {
    	return field;
    }
}
