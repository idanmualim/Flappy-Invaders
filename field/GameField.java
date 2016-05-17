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
	
	public void remove(SpaceObject toRemove) {
		Iterator<SpaceObject> iter = objects.iterator();
		while(iter.hasNext()) {
			if(iter.next().equals(toRemove))
				iter.remove();
		}
	}
	
	public void removeBullet(Bullet b) {
		Iterator<Bullet> iter = playerBullets.iterator();
		while(iter.hasNext()) {
			if(iter.next().equals(b))
				iter.remove();
		}
	}
	
}
