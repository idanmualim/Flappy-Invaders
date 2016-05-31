package spaceobjects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class Explosion
{
	private Image img;
	private int timer;
	private boolean done;
	private ArrayList<String> frameNames;
	private final static int EXPLOSIONTIME = 5;// The duration of each explosion frame.
	private Iterator<String> iter;
	private Location location;

	public Explosion(Location loc, GameField field)
	{
		done = false;
		timer = 0;
		frameNames = new ArrayList<String>();
		frameNames.add("explosion/frame1.png");
		frameNames.add("explosion/frame2.png");
		frameNames.add("explosion/frame3.png");
		frameNames.add("explosion/frame4.png");
		frameNames.add("explosion/frame5.png");
		iter = frameNames.iterator();
		location = loc;
	}

	public void act() {
		if (timer % EXPLOSIONTIME == 0)
		{
			if (iter.hasNext())
				setImg(iter.next());
			else
				done = true;
		}
		timer++;
		
			
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setImg(String path) {
		img = new ImageIcon(getClass().getClassLoader().getResource(path)).getImage();
	}
	
	public Image getImg() {
		return img;
	}
	
	public boolean checkDone() {
		return done;	
	}

}
