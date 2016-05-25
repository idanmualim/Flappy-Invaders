package spaceobjects;

import java.awt.Image;

import javax.swing.ImageIcon;

import field.GameField;
import field.Hitbox;
import field.Location;

public class SpaceObject {

	private Location location;
	private double xSpeed, ySpeed;
	private GameField gField;
	private Hitbox hitbox;
	private Image img;
	
	public SpaceObject() {}
	
	public SpaceObject(Location loc, int xVel, int yVel, GameField field, int width, int height) {
		location = loc;
		xSpeed = xVel;
		ySpeed = yVel;
		gField = field;
		hitbox = new Hitbox(loc, width, height);
	}
	
	public void act() {
		move();
	}
	
	public void move() {
		double xVal = location.getX();
		double yVal = location.getY();
		xVal += xSpeed;
		yVal += ySpeed;
		location.setLocation((int)xVal, (int)yVal);
		hitbox.changeLocation((int)xVal, (int)yVal);
		changeVelocity();
		
	}
	
	public void shoot() {
		Location loc = getLocation();
		Bullet b = new Bullet(new Location(loc.getX() - 1, loc.getY() + (hitbox.getHeight() / 2)), false);
		getGameField().addToField(b);
		
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
	
	public void setXVel(double velocity) {
		xSpeed = velocity;
	}
	
	/**
	 * @return Velocity in X direction
	 */
	public double getXVel() {
		return xSpeed;
	}
	
	public void setYVel(double velocity) {
		ySpeed = velocity;
	}
	
	/**
	 * @return Velocity in Y direction
	 */
	public double getYVel() {
		return ySpeed;
	}
	
	public void setGameField(GameField field) {
		gField = field;
	}
	
	public GameField getGameField() {
		return gField;
	}
	
	public void setHitbox(Hitbox h) {
		hitbox = h;
	}
	
	public Hitbox getHitBox()
	{
		return hitbox;
	}
	
	public void setImg(String path) {
		img = new ImageIcon(getClass().getClassLoader().getResource(path)).getImage();
	}
	
	public Image getImg() {
		return img;
	}
	
}
