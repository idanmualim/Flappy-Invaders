package spaceobjects;

import field.GameField;
import field.Location;

public class ShipType2 extends SpaceObject
{
	int timer;

	public ShipType2(Location loc, GameField field) {
		super(loc, -10, 0, field, 54, 60);
		setImg("ship2.png");
		timer = 0;

	}

	public void act()
	{
		timer++;
		changeVelocity();
		move();
	}

	public void changeVelocity() {
		setYVel(-Math.cos(timer * Math.PI / 20) * 10);
	}
}
