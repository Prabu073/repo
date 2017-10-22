package design.Chess;

public final class Chess 
{
	private Square[][] board;
	private Player player1,player2;
	boolean isPlayers1sTurn = true;
	private int drawMoveCount = 0;
	Chess(Player p1, Player p2)
	{
		this.player1 =p1;
		this.player2=p2;
		board = new Square[8][8];
		fillBoard();
		playGame();
	}
	public void drawBoard()
	{
	}
	public Player getPlayer1()
	{
		return player1;
	}
	public Player getPlayer2()
	{
		return player2;
	}
	private void fillBoard()//to fill the color and to place the coins
	{
		populateCoins();
	}
	private void populateCoins()
	{
	}
	private void playGame()
	{
		Player p;
		while(isGameOver())
		{
			p = isPlayers1sTurn?player1:player2;
			isPlayers1sTurn = !isPlayers1sTurn;
			move(p,getCoinToMove(p),getPositionToMove());
		}
		declareMatchResult();
	}
	private void declareMatchResult()
	{
		
	}
	private Position getPositionToMove()
	{
		return null;
	}
	private Coin getCoinToMove(Player p)
	{
		Coin c=null;
		do
		{
			
		}while(!isValidColor(p,c));
		return c;
	}
	private void move(Player p,Coin c,Position position)
	{
		while(!isValidMove(p,c,position))
		{
			c = getCoinToMove(p);
			position = getPositionToMove();
		};
		//further logic goes here
	}
	private boolean isGameOver()
	{
		//checkMate or by draw move count
		return false;
	}
	private boolean isValidMove(Player player,Coin c, Position pos)
	{
		if(isValidColor(player,c) && isValidCoin(c))
		{
			
		}
		return false;
	}
	private Position[] showPossibleMoves(Coin c)
	{
		Position[] p =  c.getNextPossibleMoves();
		return null;
	}
	private boolean isValidColor(Player player, Coin c)
	{
		if(player.getColor() == c.getColor())
			return true;
		return false;
	}
	private boolean isValidCoin(Coin c)
	{
		return c.isInGame();
	}
	private void undo(){}//imagine that we have double ended queue which stores each state of the game.
}
