package spaceobjects;

import javax.swing.ImageIcon;
import field.GameField;
import field.Location;

public class ShipType1 extends SpaceObject
{
	private final static int VELOCITY = 0; //ship stays in one place
	private int timer;

	public ShipType1(Location loc, GameField field) {
		super(loc, 0, 0, field, 31, 22);
		setImg(new ImageIcon("src/enemy_type_1.png").getImage());
		timer = 30;
	}

	public void act()
	{
		//Functionality: stays in one place, shoots periodically
	}

}
