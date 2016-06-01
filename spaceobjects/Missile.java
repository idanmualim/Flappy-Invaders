package spaceobjects;

import field.GameField;
import field.Location;

public class Missile extends SpaceObject
{
    private static final int WIDTH = 20;//put width (horizontal length) of missile hitbox here
    private static final int HEIGHT = 5;//put height (vertical length) of missile hitbox here
    private static final int INITXSPEED = -5;//put initial horizontal speed here (Make sure it's negative)
    private static final int ACCELERATION = -3;//put acceleration of missile to the left. (Make sure it's negative)
    private final static int SCORE = 100;
    private int xSpeed;
    
    public Missile(Location loc, GameField field)
    {
    	super(loc, INITXSPEED, 0, field, WIDTH, HEIGHT);
    	xSpeed = INITXSPEED;
    	setImg("missile.png");
    }
    
    public void act()
    {
        xSpeed += ACCELERATON;
        setXVel(xSpeed + ACCELERATION);
        move;
    }
    
    public int getScore() {
        return SCORE;
    }
}
