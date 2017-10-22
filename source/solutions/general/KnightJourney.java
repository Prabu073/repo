package solutions.general;

import java.util.Scanner;

public class KnightJourney 
{
	private int row,col;
	private int[][] chess = null;
	
	KnightJourney(int row, int col)
	{
		this.row = row;
		this.col = col;
		chess = new int[row][col];
		for(int i=0;i<row;i++)
			for(int j=0; j<col;j++)
				chess[i][j]=-1;
	}
	public boolean isValidMove(int i, int j, int previousMoveCount)
	{
		if(i<0|| i>=row)
			return false;
		else if(j<0 || j>=col)
			return false;
		else if(chess[i][j] == 0)
			return false;
		else if(chess[i][j] != -1 && chess[i][j] < previousMoveCount+1)
			return false;
		return true;
	}
	public void fillMove(int i, int j,int previousMoveCount)
	{
		if(isValidMove(i-2,j+1,previousMoveCount))
		{
			chess[i-2][j+1] = previousMoveCount+1;
			fillMove(i-2,j+1,chess[i-2][j+1]);
		}
		if(isValidMove(i-2,j-1,previousMoveCount))
		{
			chess[i-2][j-1] = previousMoveCount+1;
			fillMove(i-2,j-1,chess[i-2][j-1]);
		}
		if(isValidMove(i+2,j+1,previousMoveCount))
		{
			chess[i+2][j+1] = previousMoveCount+1;
			fillMove(i+2,j+1,chess[i+2][j+1]);
		}
		if(isValidMove(i+2,j-1,previousMoveCount))
		{
			chess[i+2][j-1] = previousMoveCount+1;
			fillMove(i+2,j-1,chess[i+2][j-1]);
		}
		if(isValidMove(i-1,j+2,previousMoveCount))
		{
			chess[i-1][j+2] = previousMoveCount+1;
			fillMove(i-1,j+2,chess[i-1][j+2]);
		}
		if(isValidMove(i-1,j-2,previousMoveCount))
		{
			chess[i-1][j-2] = previousMoveCount+1;
			fillMove(i-1,j-2,chess[i-1][j-2]);
		}
		if(isValidMove(i+1,j+2,previousMoveCount))
		{
			chess[i+1][j+2] = previousMoveCount+1;
			fillMove(i+1,j+2,chess[i+1][j+2]);
		}
		if(isValidMove(i+1,j-2,previousMoveCount))
		{
			chess[i+1][j-2] = previousMoveCount+1;
			fillMove(i+1,j-2,chess[i+1][j-2]);
		}
	}
	
	public static void print(int[][] array, int row, int col)
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0; j<col;j++)
				System.out.print(array[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args)throws Exception
	{
		int x = 0, y = 0; 
		System.out.println("Board dimension\nEnter the value of X\t:");
		Scanner in = new Scanner(System.in);
		x = in.nextInt();
		System.out.println("Enter the value of Y\t:");
		y = in.nextInt();
		int sourceX =0, sourceY =0;
		System.out.println("The knight’s starting position\nEnter the value of X\t:");
		sourceX = in.nextInt();
		System.out.println("Enter the value of Y\t:");
		sourceY = in.nextInt();
		KnightJourney knightJourney = new KnightJourney(y,x);
		knightJourney.chess[sourceY][sourceX]=0;
		knightJourney.fillMove(sourceY, sourceX, 0);
		print(knightJourney.chess,knightJourney.row,knightJourney.col);
		in.close();
	}
}
