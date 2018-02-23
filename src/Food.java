public class Food {
	private int pointsGiven;
	private int speed;
	private int foodX;
	private int foodY;
	public Food()
	{
		pointsGiven = 0;
		speed =0;
		foodX =0;
		foodY=0;
	}
	public Food(int newp, int news)
	{
		speed = news;
		pointsGiven = newp;
	}
	public int getSpeed()
	{
		return speed;
	}
	public int getPoints()
	{
		return pointsGiven;
	}
	public int getX()
	{
		return foodX;
	}
	public int getY()
	{
		return foodY;
	}
	
	
	public void setX(int newX)
	{
		foodX = newX;
	}
	public void setY(int newY)
	{
		foodY = newY;
	}
	public void setSpeed(int news)
	{
		speed =news;
	}
	public void setPoints(int newp)
	{
		pointsGiven = newp;
	}
}
