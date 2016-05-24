package spaceobjects;
import javax.swing.ImageIcon;

import field.GameField;
import field.Location;

public class ShipType3 extends SpaceObject
{

    private static final int verticalVelocity = 5;//Insert velocity here.
    private final static int WIDTH = 31;//Insert horizontal length here.
    private final static int HEIGHT = 32;//Insert vertical length here.
    private final static int FieldHeight = 600;//Insert the height of the gamefield here.
    private int timer;

    public ShipType3(Location loc, GameField field)
    {
        super(loc, 0, verticalVelocity, field, WIDTH, HEIGHT);
        setImg(new ImageIcon("enemy_type_1.png").getImage());
        timer = 30;
    }

    public void act()
    {
        if (getLocation().getY() >= FieldHeight || getLocation().getY() <= 0)
            changeVelocity();
        else
            move();
        if(timer == 0) {
			//shoot(); need to implement this method
			timer = 30;
		}
		else
			timer--;
    }
    
    public void changeVelocity() {
        if (getLocation().getY() >= FieldHeight)
            setYVel(-verticalVelocity);
        else if (getLocation().getY() <= 0)
            setYVel(verticalVelocity);
    }
}
