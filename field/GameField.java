import java.util.ArrayList;

import spaceobjects.SpaceObject;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private int score;
	private int shipsDestroyed;
	private int timer;
	
	public GameField() {
		
	}
	
	public void step() {
		
	}
	
	public void checkHit() {
		
	}
	
	public void addToField(SpaceObject toAdd) {
		objects.add(toAdd);
	}
	
	public void addBulletToField(Bullet toAdd) {
		playerBullets.add(toAdd);
	}
	
	public SpaceObject remove(SpaceObject toRemove) {
		return null;
	}
	
}