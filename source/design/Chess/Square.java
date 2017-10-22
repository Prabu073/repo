package design.Chess;

import design.Chess.Constant.Color;

public class Square
{
	private Color color;
	private Coin coin;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Coin getCoin() {
		return coin;
	}
	public void setCoin(Coin coin) {
		this.coin = coin;
	}
}
