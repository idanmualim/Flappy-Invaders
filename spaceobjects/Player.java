package spaceobjects;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final int INITIAL_VELOCITY = 5;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 0, 0);
		setImg(new ImageIcon("src/enemy_type_1.png").getImage());
	}
	
	public void act() {
		setYVel(getYVel() + 1);
		move();
	}
	
	public void bounce() {
		setYVel(INITIAL_VELOCITY);
	}

	public void shoot() {
		Bullet b = new Bullet(getLocation(), true);
		getGameField().addBulletToField(b);
		
	}
	
}
