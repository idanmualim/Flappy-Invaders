package spaceobjects;

import field.GameField;
import field.Location;

public class ShipType2 extends SpaceObject
{

    public ShipType2(Location loc, GameField field) {
		super(loc, field);
        
    }

    public act()
    {
        //moves randomly towards player does not shoot
        //random movement generation
        int random1 = (Math.random()*2) + 1) // up or down
        if(random1 = 1)
            setYVel(-(Math.random() * 3)+1) //how fast down, change if numbers are too small
        else
            setYVel((Math.random() * 3)+1) //how fast up
        setXVel((Math.random() * 3)+1) //how fast forward
        move();
        
    }
}
