package spaceobjects;
import field.GameField;
import field.Location;

public class ShipType1 extends SpaceObject
{
	private final static int VELOCITY = 0; //ship stays in one place
	private final static int FIRERATE = 60;
	private int timer;

	public ShipType1(Location loc, GameField field) {
		super(loc, -15, 0, field, 62, 44);
		setImg("ship1.png");
		timer = FIRERATE;
	}

	public void act()
	{
		move();
		//moves in from offscreen before stopping
		if(getXVel() < 0) {
			setXVel(getXVel() + 0.7);
			timer = FIRERATE;
		}
		
		timer--;
		if (timer <= 0)
		{
			shoot();
			timer = FIRERATE;
		}
			
		
	}

}
