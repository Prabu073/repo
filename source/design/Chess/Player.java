package design.Chess;

import design.Chess.Constant.Color;

public class Player 
{
	private long id;
	private Color color;
	private String name=null;
	public Player(long id,Color c)
	{
		this.id=id;
		this.color=c;
	}
	public long getId() 
	{
		return id;
	}
	public Color getColor() {
		return color;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}
