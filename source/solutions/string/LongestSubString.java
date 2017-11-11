package solutions.string;

public class LongestSubString 
{
	public static void main(String[] aaa)throws Exception
	{
		String a="LongestSubstring",b="heartstrings";
		LongestSubString lss = new LongestSubString();
		System.out.println(lss.getLongestSubString(a,b));
	}
	public String getLongestSubString(String a,String b)
	{
		if(b!= null && a.length()>0 && b!= null && b.length()>0)
		{
			int max = 0;
			int n = a.length();
			int m = b.length();
			int bEnd = 0;
			int[][] table = new int[n+1][m+1];
			for(int i=0;i<n+1;i++)
			{
				table[i][0]=0;
			}
			for(int i=0;i<m+1;i++)
			{
				table[0][i]=0;
			}
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=m;j++)
				{
					if(a.charAt(i-1) == b.charAt(j-1))
					{
						table[i][j] = table[i-1][j-1]+1;
						if(max<table[i][j])
						{
							max = table[i][j];
							bEnd = j;
						}
					}
					else
					{
						table[i][j]=0;
					}
				}
			}
			return b.substring(bEnd-max,bEnd);
		}
		return null;
	}
}
