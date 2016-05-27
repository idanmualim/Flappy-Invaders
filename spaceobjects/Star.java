package spaceobjects;

import field.GameField;
import field.Location;

public class Star extends SpaceObject
{
	private final static int WIDTH = 3;//Place width (horizontal size) of asteroid here.
	private final static int HEIGHT = 3;//Place height (vertical size) of asteroid here.
	private final static int SLOW = -1;//Gives the appearance of being farthest stars.
	private final static int MEDIUM = -3;
	private final static int FAST = -5;//Gives the appearance of being closest stars.

	public Star(Location loc, GameField field)
	{
		super(loc, 0, 0, field, WIDTH, HEIGHT);
		int starColor = (int)(Math.random() * 7);//Start of color selector code
		if (starColor <= 3)
			setImg("WhiteStar.png");
		else if (starColor == 4)
			setImg("BlueStar.png");
		else if (starColor == 5)
			setImg("YellowStar.png");
		else if (starColor == 6)
			setImg("RedStar.png");//End of color selector code

		int speedID = (int) (Math.random() * 3);
		if (speedID == 0)
			setXVel(SLOW);
		else if (speedID == 1)
			setXVel(MEDIUM);
		else if (speedID == 2)
			setXVel(FAST);

	}

	public void act() {
		move();
	}

}
