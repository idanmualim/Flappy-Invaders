package spaceobjects;

import java.awt.Image;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class ShipType1 extends SpaceObject
{
	private final static int VELOCITY = 0; //ship stays in one place
	private int timer;

	public ShipType1(Location loc, GameField field) {
		super(loc, 0, 0, field, 31, 22);
		setImg(new ImageIcon("enemy_type_1.png").getImage());
		timer = 30;
	}

	public void act()
	{
		if(timer == 0) {
			shoot();
			timer = 30;
		}
		else
			timer--;
	}
	public void shoot()
	{
		Bullet b = new Bullet(getLocation(), false);
		getGameField().addBulletToField(b);
	}
}
