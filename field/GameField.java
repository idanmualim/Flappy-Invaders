package field;

import java.util.ArrayList;
import java.util.Iterator;

import control.Controller;
import spaceobjects.Asteroid;
import spaceobjects.Bullet;
import spaceobjects.Player;
import spaceobjects.SpaceObject;

import spaceobjects.SpaceObject;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private Player player;
	private int score;
	private int shipsDestroyed;
	private boolean gameOver;
	Controller control;
	private static final int FIELDWIDTH = 600; //Insert width of field here.
	
	public GameField(Controller controller) {
		gameOver = false;
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
		player.move();//TO BE EDITED moves player  HOW TO MAKE JUMP IDK
		checkHit();
		removeOutOfBounds();
		score ++; //should score be updated where timer is? or is here ok
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
		if (player.getLocation().getY() < 0)
			gameOver = true;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getShipsDestroyed() {
		return shipsDestroyed;
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
