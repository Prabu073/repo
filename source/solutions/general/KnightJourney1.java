package solutions.general;

import java.util.ArrayList;

public class KnightJourney1 
{
	int[][] chess = new int[8][8];
	int count=0;
	/*
0 3 2 3 2 3 4 5 
3 4 1 2 3 4 3 4 
2 1 4 3 2 3 4 5 
3 2 3 2 3 4 3 4 
2 3 2 3 4 3 4 5 
3 4 3 4 3 4 5 4 
4 3 4 3 4 5 4 5 
5 4 5 4 5 4 5 6 */
	public static void main(String... a)throws Exception
	{
		KnightJourney1 kj = new KnightJourney1();
		Position s = new Position(0,0);
		Position d = new Position(7,6 );
		System.out.println(kj.getMinJump(s,d));
	}
	KnightJourney1()
	{
		for(int i=0;i<8;i++)
			for(int j=0; j<8;j++)
				chess[i][j]=-1;
	}
	public int getMinJump(Position s, Position d)
	{
		if(d.isEqual(s))
		{
			return 0;
		}
		chess[s.getX()][s.getY()]=0;
		ArrayList<Position> p = getValidJump(s);
		return getMinJumpUtil(p,d);
	}
	public int getMinJumpUtil(ArrayList<Position> p, Position d)
	{
		count++;
		if(p.size()==0)
			return 0;
		for(int i=0; i<p.size();i++)
		{
			if(d.isEqual(p.get(i)))
			{
				return 1;
			}
		}
		ArrayList<Position> list = new ArrayList<>();
		for(int i=0; i<p.size();i++)
		{
			list.addAll(getValidJump(p.get(i)));
		}
		int jump = getMinJumpUtil(list,d);
		if(jump != 0)
		{
			jump+=1;
		}
		return jump;
	}
	public ArrayList<Position> getValidJump(Position p)
	{
		ArrayList<Position> list = new ArrayList<>();
		int i = p.getX(), j = p.getY();
		if(isValidMove(i-2,j+1))
		{
			list.add(new Position(i-2,j+1));
		}
		if(isValidMove(i-2,j-1))
		{
			list.add(new Position(i-2,j-1));
		}
		if(isValidMove(i+2,j+1))
		{
			list.add(new Position(i+2,j+1));
		}
		if(isValidMove(i+2,j-1))
		{
			list.add(new Position(i+2,j-1));
		}
		if(isValidMove(i-1,j+2))
		{
			list.add(new Position(i-1,j+2));
		}
		if(isValidMove(i-1,j-2))
		{
			list.add(new Position(i-1,j-2));
		}
		if(isValidMove(i+1,j+2))
		{
			list.add(new Position(i+1,j+2));
		}
		if(isValidMove(i+1,j-2))
		{
			list.add(new Position(i+1,j-2));
		}
		return list;
	}
	public boolean isValidMove(int i, int j)
	{
		if(i<0|| i>=8)
			return false;
		else if(j<0 || j>=8)
			return false;
		else if(chess[i][j] == 0)
			return false;
		else if(chess[i][j] ==1)
			return false;
		chess[i][j]=1;
		return true;
	}
}
