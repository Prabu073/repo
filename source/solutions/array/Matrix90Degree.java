package solutions.array;

public class Matrix90Degree 
{
	private int n;
	Matrix90Degree(int n)
	{
		this.n=n;
	}
	private void swap(int i,int j,int m, int n,int[][] a)
	{
		int temp = a[i][j];
		a[i][j]=a[m][n];
		a[m][n]=temp;
	}
	public void reverseColumn(int[][] a)
	{
		for(int j=0;j<n;j++)
			for(int i=0,k=n-1;i<n/2;i++,k--)
				swap(i,j,k,j,a);
	}
	public void transponseMatrix(int[][] a)
	{
		for(int i=0;i<n;i++)
			for(int j=i;j<n;j++)
				swap(i,j,j,i,a);
	}
	public void rotate(int[][] a)
	{
		reverseColumn(a);
		transponseMatrix(a);
	}
	public void print(int a[][])
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String...strings)throws Exception
	{
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Matrix90Degree obj = new Matrix90Degree(a.length);
		obj.rotate(a);
		obj.print(a);
	}
}
