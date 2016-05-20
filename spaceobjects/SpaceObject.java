package spaceobjects;

import java.awt.Image;

import field.GameField;
import field.Location;

public class SpaceObject {

	private Location location;
	private int xSpeed, ySpeed;
	private GameField gField;
	private Hitbox HitBox;
	private Image img;
	
	public SpaceObject() {}
	
	public SpaceObject(Location loc, int xVel, int yVel, GameField field, int width, int height) {
		location = loc;
		xSpeed = xVel;
		ySpeed = yVel;
		gField = field;
		HitBox = new Hitbox(loc, width, height);
	}
	
	public void act() {
		move();
	}
	
	public void move() {
		int xVal = location.getX();
		int yVal = location.getY();
		xVal += xSpeed;
		yVal += ySpeed;
		location.setX(xVal);
		location.setY(yVal);
		changeVelocity();
		
	}
	
	
	public void setLocation(Location loc) {
		location = loc;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void changeVelocity() {
		//Does nothing if velocity of object does not change. Does something if velocity does change. 
		//This is to be modified in children classes that have dynamic velocities
	}
	
	public void setXVel(int velocity) {
		xSpeed = velocity;
	}
	
	/**
	 * @return Velocity in X direction
	 */
	public int getXVel() {
		return xSpeed;
	}
	
	public void setYVel(int velocity) {
		ySpeed = velocity;
	}
	
	/**
	 * @return Velocity in Y direction
	 */
	public int getYVel() {
		return ySpeed;
	}
	
	public void setGameField(GameField field) {
		gField = field;
	}
	
	public GameField getGameField() {
		return gField;
	}
	
	public Hitbox getHitBox()
	{
		return HitBox;
	}
	
	public void setImg(Image image) {
		img = image;
	}
	
	public Image getImg() {
		return img;
	}
	
}
