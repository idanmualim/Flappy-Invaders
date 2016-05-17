import java.util.ArrayList;

import spaceobjects.SpaceObject;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private Player player;
	private int score;
	private int shipsDestroyed;
	private int timer;
	private boolean gameOver;
	
	public GameField() {
		gameOver = false;
	}
	
	public void step() {
		checkHit();
		timer++;
		score ++;
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
						score += 50;
						shipsDestroyed++;
					}
				}
			}
		}
		for (int b = 0; b < objects.size(); b++)
		{
			if (player.getHitBox().checkCollision(objects.get(b).getHitBox()))
				gameOver = true; 
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
	
	public boolean isGameOver() {
		return gameOver;
	}
}
