package spaceobjects;

import java.awt.Image;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class ShipType1 extends SpaceObject
{
	private final int VELOCITY = 0; //ship stays in one place
	private ImageIcon img;

	public ShipType1(Location loc, GameField field) {
		super(loc, 0, 0, field);
		img = new ImageIcon("enemy_type_1.png");
	}

	public void act()
	{
		//doesnt move
	}
	public void shoot()
	{
		Bullet b = new Bullet(getLocation(), false);
		getGameField().addBulletToField(b);
	}

	public Image getImg() {
		return img.getImage();
	}
}
