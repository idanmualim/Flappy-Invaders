package field;

import java.util.ArrayList;
import java.util.Iterator;

import control.Controller;
import spaceobjects.Asteroid;
import spaceobjects.Bullet;
import spaceobjects.Player;
import spaceobjects.SpaceObject;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private Player player;
	private int score;
	private int shipsDestroyed;
	private int shotsFired;
	private int time;
	Controller control;
	private static final int FIELDWIDTH = 600; //Insert width of field here.
	private static final int FIELDHEIGHT = 600;
	
	public GameField(Controller controller) {
		control = controller;
		objects = new ArrayList<SpaceObject>();
		playerBullets = new ArrayList<Bullet>();
		player = new Player(new Location(40, 300), 0, 0, this);
		addToField(player);
	}
	
	public void step() {
		for (int i = 0; i < objects.size(); i++) //Moves all enemy SpaceObjects
			objects.get(i).move();
		for (int b = 0; b < playerBullets.size(); b++)//Moves all player bullets
			playerBullets.get(b).move();
		player.act();
		checkHit();
		removeOutOfBounds();
		
		score++;
		time ++;
		control.updateGUI();
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
					if (!(objects.get(z) instanceof Asteroid))//Destroyed SpaceObject if it's not an asteroid
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
				control.onGameOver();
		}
	}
	
	public void addToField(SpaceObject toAdd) {
		objects.add(toAdd);
	}
	
	public void addBulletToField(Bullet toAdd) {
		playerBullets.add(toAdd);
		shotsFired++;
	}
	
	public void remove(SpaceObject toRemove) {
		Iterator<SpaceObject> iter = objects.iterator();
		while(iter.hasNext()) {
			if(iter.next() == toRemove)
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
	
	public void removeOutOfBounds()
	{
		for (int i = 0; i < objects.size(); i++)
		{
			if (objects.get(i).getLocation().getX() < 0)
				remove(objects.get(i));
		}
		for (int i = 0; i < playerBullets.size(); i++)
		{
			if (playerBullets.get(i).getLocation().getX() > FIELDWIDTH)
				remove(playerBullets.get(i));
		}
		if (player.getLocation().getY() > FIELDHEIGHT) {
			remove(player);
			control.onGameOver();
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public int getShipsDestroyed() {
		return shipsDestroyed;
	}
	
	public int getShotsFired() {
		return shotsFired;
	}
	
	public double getTime() {
		return time;
	}
	
	public ArrayList<SpaceObject> getSpaceObjects() {
		return objects;
	}
	
	public ArrayList<Bullet> getPlayerBullets() {
		return playerBullets;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
