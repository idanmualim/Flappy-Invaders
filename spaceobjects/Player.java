package spaceobjects;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final int INITIAL_VELOCITY = -5;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 31, 22);
		setImg("enemy_type_1.png");
	}
	
	public void act() {
		setYVel(getYVel() + 1);
		move();
	}
	
	public void bounce() {
		setYVel(INITIAL_VELOCITY);
	}

	public void shoot() {
		Location loc = getLocation();
		Bullet b = new Bullet(new Location(loc.getX() + 31, loc.getY()), true);
		getGameField().addBulletToField(b);
		
	}
	
}
