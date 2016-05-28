package spaceobjects;

import field.GameField;
import field.Location;

public class ShipType2 extends SpaceObject
{
	private final static int MOVERATE = 30;
	int timer;
	
    public ShipType2(Location loc, GameField field) {
		super(loc, 0, 0, field, 54, 60);
		setImg("ship2.png");
		timer = MOVERATE;
        
    }

    public void act()
    {
        if(timer <= 0) {
		changeVelocity();
		timer = MOVERATE;
	}
	else
		timer--;
	
	if(getLocation().getY() >= 536 || getLocation().getY() <= 64)
		setYVel(-getYVel());
        move();
        
    }
    
    public void changeVelocity() {
    	//moves randomly towards player does not shoot
        //random movement generation
        int random1 = (int) ((Math.random()*2) + 1); // up or down
        if(random1 == 1)
            setYVel(-(Math.random() * 5 + 5)); //how fast down, change if numbers are too small
        else
            setYVel(Math.random() * 5 + 5); //how fast up
        setXVel(-(Math.random() * 5 + 5)); //how fast forward
    }
}
