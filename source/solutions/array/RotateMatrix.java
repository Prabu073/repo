package solutions.array;

import java.util.Scanner;

class RotateMatrix 
{
	public static void main (String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i=0;i<testCases;i++)
		{
			int row = in.nextInt();
			int col = in.nextInt();
			int k = in.nextInt();
			int[][] array = new int[row][col];
			for(int r =0;r<row;r++)
				for(int c=0;c<col;c++)
					array[r][c] = in.nextInt();
			rotate1(k,array,row,col);
			print(array,row,col);
		}
		in.close();
	}
	public static void print(int[][] array, int row, int col)
	{
		for(int i =0;i<row;i++)
			for(int j=0;j<col;j++)
				System.out.print(array[i][j]+" ");
	}
	public static void rotate(int k, int[][] array, int row, int col)
	{
		int k1=k;
		for(int i=0;i<row;i++)
		{
			while(k1>0)
			{
				int temp = array[i][0];
				for(int j=0;j<col-1;j++)
					array[i][j]=array[i][j+1];
				array[i][col-1]=temp;
				k1--;
			}
			k1=k;
		}
	}
	public static void rotate1(int k, int[][] array, int row, int col)
	{
		int k1=k;
		while(k1>0)
		{
			int temp = array[0][0];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col-1;j++)
					array[i][j]=array[i][j+1];
				if(i<row-1)
					array[i][col-1]=array[i+1][0];
				else
					array[i][col-1]=temp;
			}
			k1--;
		}
	}
}