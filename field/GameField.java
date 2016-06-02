package field;

import java.util.ArrayList;
import java.util.Iterator;

import control.Controller;
import spaceobjects.Asteroid;
import spaceobjects.Bullet;
import spaceobjects.Explosion;
import spaceobjects.Missile;
import spaceobjects.Player;
import spaceobjects.ShipType1;
import spaceobjects.ShipType2;
import spaceobjects.ShipType3;
import spaceobjects.SpaceObject;
import spaceobjects.Star;

public class GameField {

	private ArrayList<SpaceObject> objects;
	private ArrayList<Bullet> playerBullets;
	private ArrayList<Star> stars;
	private ArrayList<Explosion> explosions;
	private Player player;
	private int score;
	private int shipsDestroyed;
	private int shotsFired;
	private int time;
	private Controller control;
	private static final int FIELDWIDTH = 600; //Insert width of field here.
	private static final int FIELDHEIGHT = 600;
	private static final int ENEMYSPAWNXCOOR = 680;//This is the x-coordinate that the enemies spawn at. (offscreen)
	private static final int ENEMYSPAWNYRANGE = 472; //Enemies can spawn in an area of 472 pixels between
														//the top and bottom of the field
	private static final int INITIALSPAWNRATE = 60; //Respawns new enemy every x ticks, can be modified to increase over time
	private int spawnRate;
	private static final int ASTEROIDTIMER = 60;
	private static final int DESPAWNX = -60;
	
	private static final int STARSPAWNRATE = 5;
	
	public GameField(Controller controller) {
		control = controller;
		objects = new ArrayList<SpaceObject>();
		playerBullets = new ArrayList<Bullet>();
		stars = new ArrayList<Star>();
		explosions = new ArrayList<Explosion>();
		player = new Player(new Location(-40, 300), 16, 0, this);
		addToField(player);
		spawnRate = INITIALSPAWNRATE;
	}
	
	public void step() {
		for (int x = 0; x < stars.size(); x++)
			stars.get(x).act();
		for (int i = 0; i < objects.size(); i++) //Moves all enemy SpaceObjects
			objects.get(i).act();
		for (int b = 0; b < playerBullets.size(); b++)//Moves all player bullets
			playerBullets.get(b).act();
		for (int e = 0; e < explosions.size(); e++)
			explosions.get(e).act();
		//player.act();
		checkHit();
		removeOutOfBounds();
		removeFinishedExplosions();
		if (time % spawnRate == 0)
			spawnRandom();
		if (time % STARSPAWNRATE == 0)
			spawnStar();
		if (time % ASTEROIDTIMER == 0)
			spawnEnemy("Asteroid");
		score++;
		time++;
		increaseSpawnRate();
		control.updateGUI();
	}
	
	public void increaseSpawnRate() {
		if (spawnRate > 20 && (time % 150 == 0))
			spawnRate--;
 	}
	
	public void checkHit() {
		for (int z = 0; z < objects.size(); z++)
		{
			for (int i = 0; i < playerBullets.size(); i++)//Checks for collisions between player fired bullets and enemy objects.
			{
				
				if (playerBullets.get(i).getHitBox().checkCollision(objects.get(z).getHitBox()))
				{
					playerBullets.remove(i);
					i--;
					if (!(objects.get(z) instanceof Asteroid || objects.get(z) instanceof Bullet))//Destroyed SpaceObject if it's not an asteroid
					{
						Explosion explosion = new Explosion(objects.get(z).getLocation(), this);
						addExplosion(explosion);
						score += objects.get(z).getScore();
						objects.remove(z);
						z--;
						shipsDestroyed++;
					} else if (objects.get(z) instanceof Bullet) {
						objects.remove(z);
						z--;
						score += 10;
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
	
	public void addExplosion(Explosion explosion) {
		explosions.add(explosion);
	}
	
	public void removeFinishedExplosions() {
		Iterator<Explosion> iter = explosions.iterator();
		while (iter.hasNext()) {
			if (iter.next().checkDone())
				iter.remove();
		}
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
			if (objects.get(i).getLocation().getX() < DESPAWNX || objects.get(i).getLocation().getY() > FIELDHEIGHT) {
				objects.remove(i);
				i--;
			}
		}
		for (int i = 0; i < playerBullets.size(); i++)
		{
			if (playerBullets.get(i).getLocation().getX() > FIELDWIDTH)
				playerBullets.remove(i);
		}
		for (int x = 0; x < stars.size(); x++)
		{
			if (stars.get(x).getLocation().getX() < DESPAWNX)
				stars.remove(x);
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
	
	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public ArrayList<Explosion> getExplosions() {
		return explosions;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void spawnRandom()
	{
		int id = (int)(Math.random() * 5);
		switch (id) {
			case 0: spawnEnemy("Missile");
				break;
			case 1: spawnEnemy("Missile");
				break;
			case 2: spawnEnemy("Ship1");
				break;
			case 3: spawnEnemy("Ship2");
				break;
			case 4: spawnEnemy("Ship3");
				break;
		}
	}
	
	public void spawnEnemy(String name) {
		Location spawnLoc = new Location(ENEMYSPAWNXCOOR, (int)(Math.random() * ENEMYSPAWNYRANGE) + 64);
		switch (name) {
			case "Asteroid": 
				Asteroid asteroid = new Asteroid(spawnLoc, this);
				addToField(asteroid);
				break;
			case "Missile": 
				Missile missile = new Missile(spawnLoc, this);
				addToField(missile);
				break;
			case "Ship1":
				ShipType1 ship1 = new ShipType1(spawnLoc, this);
				addToField(ship1);
				break;
			case "Ship2":
				ShipType2 ship2 = new ShipType2(spawnLoc, this);
				addToField(ship2);
				break;
			case "Ship3":
				ShipType3 ship3 = new ShipType3(spawnLoc, this);
				addToField(ship3);
				break;
			default:
			break;
		}
		
	}
	
	
	public void spawnStar() {
		Location spawnLoc = new Location(ENEMYSPAWNXCOOR, (int)(Math.random() * FIELDHEIGHT));
		Star star = new Star(spawnLoc, this);
		stars.add(star);
	}
	
}
