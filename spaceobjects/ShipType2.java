package spaceobjects;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class ShipType2 extends SpaceObject
{

    public ShipType2(Location loc, GameField field) {
		super(loc, 0, 0, field, 27, 30);
		setImg(new ImageIcon("enemy_type_2.png").getImage());
        
    }

    public void act()
    {
        if(timer == 0) {
		changeVelocity();
		timer = 30;
	}
	else
		timer--;
        move();
        
    }
    
    public void changeVelocity() {
    	//moves randomly towards player does not shoot
        //random movement generation
        int random1 = (Math.random()*2) + 1) // up or down
        if(random1 = 1)
            setYVel(-(Math.random() * 3)+1) //how fast down, change if numbers are too small
        else
            setYVel((Math.random() * 3)+1) //how fast up
        setXVel((Math.random() * 3)+1) //how fast forward
    }
}
