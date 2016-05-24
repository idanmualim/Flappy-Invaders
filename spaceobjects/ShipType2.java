package spaceobjects;

import field.GameField;
import field.Location;

public class ShipType2 extends SpaceObject
{
	private final static int MOVERATE = 30;
	int timer;
	
    public ShipType2(Location loc, GameField field) {
		super(loc, 0, 0, field, 27, 30);
		setImg("enemy_type_2.png");
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
        move();
        
    }
    
    public void changeVelocity() {
    	//moves randomly towards player does not shoot
        //random movement generation
        int random1 = (int) ((Math.random()*2) + 1); // up or down
        if(random1 == 1)
            setYVel((int) -((Math.random() * 5) + 5)); //how fast down, change if numbers are too small
        else
            setYVel((int) ((Math.random() * 5) + 5)); //how fast up
        setXVel((int) -((Math.random() * 5) + 5)); //how fast forward
    }
}
