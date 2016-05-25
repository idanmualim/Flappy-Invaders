package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final int INITIAL_VELOCITY = -8;
	double trueYVel;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 62, 44);
		setImg("enemy_type_1.png");
	}
	
	public void act() {
		trueYVel += 0.3;
		setYVel((int)trueYVel);
		move();
	}
	
	public void bounce() {
		trueYVel = INITIAL_VELOCITY;
		setYVel(INITIAL_VELOCITY);
	}

	public void shoot() {
		Location loc = getLocation();
		Bullet b = new Bullet(new Location(loc.getX() + 31, loc.getY() + 11), true);
		getGameField().addBulletToField(b);
		
	}
	
}
