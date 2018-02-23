
public class Player 
{
	private int positionX, positionY;
	private int points;
	private int health;
	private boolean alive;
	public Player()
	{
		positionX=0;
		positionY = 0;
		points =0;
		health =100;
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
	public boolean getalive()
	{
		return alive;
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
	public void setalive(boolean a)
	{
		alive=a;;
	}
}
