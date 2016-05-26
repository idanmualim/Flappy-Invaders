package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final static int INITIAL_VELOCITY = -8;
	private final static int CEILING = 64;
	double trueYVel;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 62, 44);
		setImg("ship1.png");
	}
	
	public void act() {
		trueYVel += 0.3;
		setYVel((int)trueYVel);
		if (getLocation().getY() <= CEILING)
			setYVel(0);
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
