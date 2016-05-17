
public class Hitbox
{
    private int x;
	private int y;

	public Hitbox(Location location, int width, int height)
	{
		loc = location;
		x = width;
		y = height;

	}
    
    public void changeLocation(int x, int y)
    {
        loc.setLocation(x, y);
    }
    
    public double getRadius() {
        return radius;
    }

    public int getWidth() {
		return x;
	}

	public int getHeight() {
		return y;
	}

	
	public boolean checkCollision(Hitbox other) {
		return (betweenX(other) && betweenY(other));
	}
	
	private boolean betweenX(Hitbox other) {
		int xMin = loc.getX();
		int xMax = loc.getX() + getWidth();
		int oxMin = other.loc.getX();
		int oxMax = other.loc.getX() + other.getWidth();
		
		if((xMin > oxMin && xMin < oxMax) || (xMax > oxMin && xMax < oxMax))
			return true;
		if((oxMin > xMin && oxMin < xMax) || (oxMax > xMin && oxMax < xMax))
			return true;
		return false;
	}
	
	private boolean betweenY(Hitbox other) {
		int yMin = loc.getY();
		int yMax = loc.getY() + getHeight();
		int oyMin = other.loc.getY();
		int oyMax = other.loc.getY() + other.getHeight();
		
		if((yMin > oyMin && yMin < oyMax) || (yMax > oyMin && yMax < oyMax))
			return true;
		if((oyMin > yMin && oyMin < yMax) || (oyMax > yMin && oyMax < yMax))
			return true;
		return false;
	}
}
