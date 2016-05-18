package spaceobjects

    import field.GameField;
    import field.Location;
    
public class ShipType1 extends SpaceObject
{
	private final int VELOCITY = 0; //ship stays in one place
	
    public ShipType1(Location loc, GameField field) {
		super(loc, field);
    }

    public act()
    {
        //doesnt move
    }
    public shoot()
    {
    	Bullet b = new Bullet(getLocation(), false);
	getGameField().addBulletToField(b);
    }
}
