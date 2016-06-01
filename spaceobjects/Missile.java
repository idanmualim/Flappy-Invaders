package spaceobjects;

import field.GameField;
import field.Location;

public class Missile extends SpaceObject
{
    private static final int WIDTH = 50;//put width (horizontal length) of missile hitbox here
    private static final int HEIGHT = 32;//put height (vertical length) of missile hitbox here
    private static final int INITXSPEED = 0;//put initial horizontal speed here (Make sure it's negative)
    private static final double ACCELERATION = -0.5;//put acceleration of missile to the left. (Make sure it's negative)
    private final static int SCORE = 100;
    
    public Missile(Location loc, GameField field)
    {
    	super(loc, INITXSPEED, 0, field, WIDTH, HEIGHT);
    	setImg("missile.png");
    }
    
    public void act()
    {
        setXVel(getXVel() + ACCELERATION);
        move();
    }
    
    public int getScore() {
        return SCORE;
    }
}
