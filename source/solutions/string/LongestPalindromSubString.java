package solutions.string;

public class LongestPalindromSubString 
{
	public static void main(String[] aa)throws Exception
	{
		String a = null;
		LongestPalindromSubString lps = new LongestPalindromSubString();
		System.out.println("Longest palindrom substring\t :"+ lps.getLongestPalindromSubString(a));
	}
	public String getLongestPalindromSubString(String s)
	{
		if(s != null && s.length()>0)
		{
			int n = s.length();
			int max = 1;
			int start = 0;
			boolean[][] a = new boolean[n][n];
			for(int i=0;i<n;i++)
			{
				a[i][i]=true;
			}
			for(int i=0;i<n-1;i++)
			{
				if(s.charAt(i) == s.charAt(i+1))
				{
					max = 2;
					start = i;
					a[i][i+1]=true;		
				}
			}
			for(int strLen=3;strLen<=n;strLen++)
			{
				for(int i=0;i<n-strLen+1;i++)
				{
					int j = i+strLen-1;
					if(a[i+1][j-1] && s.charAt(i)==s.charAt(j))
					{
						a[i][j]=true;
						if(max < strLen)
						{
							max = strLen;
							start = i;
						}
					}
				}
			}
			return s.substring(start,start+max);
		}
		return s;
	}
}
