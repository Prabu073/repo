package solutions.general;

public class PossibleSumOfNumber 
{
	public static void main(String... strings)throws Exception
	{
		int n=6;
		possibleNumbers(n);
	}
	private static void printArray(int[] arr, int index)
	{
		for(int i=0;i<=index;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	private static void possibleNumbers(int n)
	{
		int[] arr = new int[n];
		arr[0]=n;
		int index = 0;
		while(true)
		{
			int sum =0;
			printArray(arr,index);
			while(index>=0 && arr[index] == 1)
			{
				sum++;
				index--;
			}
			if(index<0)
				return;
			arr[index]--;
			sum++;
			while(arr[index] < sum)
			{
				arr[index+1] = arr[index];
				sum = sum-arr[index];
				index++;
			}
			index++;
			arr[index]=sum;
		}
	}
}
