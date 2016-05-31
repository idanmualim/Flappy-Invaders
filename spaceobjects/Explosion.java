package spaceobjects;

import java.awt.Color;

import field.GameField;
import field.Location;

public class Explosion
{
	private Image img;
	private int timer;
	private boolean done;
	private ArrayList<String> frameNames;
	private final static int EXPLOSIONTIME = 5;// The duration of each explosion frame.
	private Iterator iter;

	public Explosion(Location loc, GameField field)
	{
		done = false;
		timer = 0; frame = 0;
		frameNames = new ArrayList<String>();
		frameNames.add("frame1.png");
		frameNames.add("frame2.png");
		frameNames.add("frame3.png");
		frameNames.add("frame4.png");
		frameNames.add("frame5.png");
		iter = frameNames.iterator();
	}

	public void act() {
		if (timer % EXPLOSIONTIME = 0)
		{
			if (iter.hasNext())
				setImg(iter.next());
			else
				done = false;
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
