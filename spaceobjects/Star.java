package spaceobjects;

import field.GameField;
import field.Location;

public class star extends SpaceObject
{
    private final static int WIDTH = 54;//Place width (horizontal size) of asteroid here.
    private final static int HEIGHT = 52;//Place height (vertical size) of asteroid here.
    private final static int MINXVEL = 5; //Place maximum x velocity here
    private final static int MINYVEL = -2; //Place maximum y velocity here
    
    public Asteroid(Location loc, GameField field)
    {
    	super(loc, (int)-(MINXVEL + Math.random() * 5), (int)(MINYVEL + Math.random() * 5), field, WIDTH, HEIGHT);
    	setImg("asteroid.png");
    }
    
    public void act() {
        move();
    }

}
