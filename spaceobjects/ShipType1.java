package spaceobjects

    import field.GameField;
    import field.Location;
    
public class ShipType1 extends SpaceObject
{
	private final int VELOCITY = 0; //ship stays in one place
	
    public ShipType1(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
    }

    public act()
    {
        //doesnt move and shoots towards the player
        Bullet b = new Bullet(getLocation(), false);
	getGameField().addBulletToField(b);
    }
}
