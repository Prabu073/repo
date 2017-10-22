package design.Chess;

import design.Chess.Constant.CoinType;
import design.Chess.Constant.Color;

public abstract class Coin 
{
	private CoinType type;
	private Color color;
	private Position position;//board should hold the position
	private boolean isInGame;
	public Coin(CoinType type,Color color)
	{
		this.type = type;
		this.color = color;
		isInGame = true;
	}
	public CoinType getType() 
	{
		return type;
	}
	public Color getColor() 
	{
		return color;
	}
	public Position getPosition() 
	{
		return position;
	}
	public void setPosition(Position position) 
	{
		this.position = position;
	}
	public boolean isInGame() 
	{
		return isInGame;
	}
	public void setInGame(boolean isInGame) 
	{
		this.isInGame = isInGame;
	}
	public abstract Position[] getNextPossibleMoves();
}
