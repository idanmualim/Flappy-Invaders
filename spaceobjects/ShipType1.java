package spaceobjects;
import field.GameField;
import field.Location;

public class ShipType1 extends SpaceObject
{
	private final static int VELOCITY = 0; //ship stays in one place
	private final static int FIRERATE = 30;
	private int timer;

	public ShipType1(Location loc, GameField field) {
		super(loc, 0, 0, field, 31, 22);
		setImg("enemy_type_1.png");
		timer = FIRERATE;
	}

	public void act()
	{
		move();
		timer--;
		if (timer <= 0)
		{
			shoot();
			timer = FIRERATE;
		}
			
		
	}

}
