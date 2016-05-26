package spaceobjects;
import field.GameField;
import field.Location;

public class ShipType3 extends SpaceObject
{

    private static final int verticalVelocity = 5;//Insert velocity here.
    private final static int WIDTH = 31;//Insert horizontal length here.
    private final static int HEIGHT = 32;//Insert vertical length here.
    private final static int MAXIMUM_HEIGHT = 536;//Insert the height of the gamefield here.
    private final static int MINIMUM_HEIGHT = 64;
    private final static int FIRERATE = 60;
    private int timer;

    public ShipType3(Location loc, GameField field)
    {
        super(loc, -15, verticalVelocity, field, WIDTH, HEIGHT);
        setImg("ship3.png");
        timer = FIRERATE;
    }

    public void act()
    {
    	if(getXVel() < 0) {
			setXVel(getXVel() + 0.7);
			timer = FIRERATE;
		}
    	
        if (getLocation().getY() >= MAXIMUM_HEIGHT || getLocation().getY() <= MINIMUM_HEIGHT)
            changeVelocity();
        move();
        
        if(timer == 0) {
			shoot();
			timer = FIRERATE;
		}
		else
			timer--;
    }
    
    public void changeVelocity() {
        if (getLocation().getY() >= MAXIMUM_HEIGHT)
            setYVel(-verticalVelocity);
        else if (getLocation().getY() <= MINIMUM_HEIGHT)
            setYVel(verticalVelocity);
    }
}
