
public class Player 
{
	private int positionX, positionY;
	private int points;
	private int health;
	private boolean alive;
	public Player()
	{
		positionX=50;
		positionY = 180;
		points =0;
		health =200;
		alive =true;
	}
	
	//get methods
	public int getX()	
	{
		return positionX;
	}
	public int getY()
	{
		return positionY;
	}
	public int getpoints()
	{
		return points;
	}
	public int gethealth()
	{
		return health;
	}
	//set methods
	public void setX(int newX)
	{
		positionX = newX;
	}
	public void setY(int newY)
	{
		positionY = newY;
	}
	public void setpoints(int newpoints)
	{
		points = newpoints;
	}
	public void sethealth(int newh)
	{
		health = newh;
	}
}
