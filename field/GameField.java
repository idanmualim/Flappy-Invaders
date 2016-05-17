import java.util.ArrayList;

import spaceobjects.SpaceObject;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private Player player;
	private int score;
	private int shipsDestroyed;
	private int timer;
	
	public GameField() {
		
	}
	
	public void step() {
		
	}
	
	public void checkHit() {
		for (int i = 0; i < playerBullets.size(); i++)//Checks for collisions between player fired bullets and enemy objects.
		{
			for (int z = 0; z < objects.size(); z++)
			{
				if (playerBullets.get(i).getHitBox().checkCollision(objects.get(z).getHitBox()))
				{
					removeBullet(playerBullets.get(i));
					i--;
					if (!(objects.get(z) instanceOf Asteroid))//Destroyed SpaceObject if it's not an asteroid
					{
						remove(objects.get(z));
						z--;
					}
				}
			}
		}
		for (int b = 0; b < objects.size(); b++)
		{
			if (player.getHitBox().checkCollision(objects.get(b).getHitBox()))
				//END GAME END GAME HERE END GAME END GAME END GAME HERE 
		}
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
