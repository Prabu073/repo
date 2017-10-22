package solutions.general;

public class Position
{
	private int x,y;
	Position(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public String toString()
	{
		return x+"-"+y;
	}
	public boolean isEqual(Position p)
	{
		return (this.x==p.getX() && this.y==p.getY());
	}
}