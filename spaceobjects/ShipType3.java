package spaceobjects;
import java.awt.Image;
import javax.swing.ImageIcon;
import field.GameField;
import field.Location;

public class ShipType3 extends SpaceObject
{
    private int x;
    private final static verticalVelocity = //Insert velocity here.
    private final static WIDTH = //Insert horizontal length here.
    private final static HEIGHT = //Insert vertical length here.
    private final static FieldHeight = //Insert the height of the gamefield here.
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
			shoot();
			timer = 30;
		}
		else
			timer--;
    }
    
    public void changeVelocity() {
        if (getLocation.getY() >= FieldHeight)
            setYVel(-verticalVelocity);
        else if (getLocation.getY() <= 0)
            setYVel(verticalVelocity);
    }
    }
}
