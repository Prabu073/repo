package solutions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//http://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
public class NoTwoAdjacentCharaAreSame 
{
	private class CharFrequency implements Comparable<CharFrequency>
	{
		 int frequency=0;
		 char c;
		 CharFrequency(char c)
		 {
			 this.c = c;
		 }
		public int compareTo(CharFrequency c) 
		{
			if(this.frequency < c.frequency)
				return 1;
			else if(this.frequency == c.frequency)
				return 0;
			else 
				return -1;
		}
		public String toString()
		{
			return c+"="+frequency;
		}
	}
	public static void main(String... strings)throws Exception
	{
		String a = "caacababababa";
		NoTwoAdjacentCharaAreSame obj = new NoTwoAdjacentCharaAreSame();
		System.out.println(obj.rearrange(a));
	}
	public String rearrange(String s)
	{
		if(s == null)
			return s;
		int len = s.length();
		if(len == 0)
			return s;
		HashMap<Character,CharFrequency> map = new HashMap<>();
		ArrayList<CharFrequency> list = new ArrayList<>();
		int max=0;
		Character preChara = null;
		boolean sameAdjacentChara = false;
		for(char c : s.toCharArray())
		{
			CharFrequency f = map.get(c);
			if(f == null)
			{
				f = new CharFrequency(c);
				map.put(c, f);
				list.add(f);
			}
			if(preChara != null && preChara == c)
			{
				sameAdjacentChara = true;
			}
			preChara = c;
			f.frequency++;
			if(max < f.frequency)
				max = f.frequency;
		}
		map = null;
		if(max < 2 || sameAdjacentChara == false)
			return s;
		else if(max > (len/2)+1)
			return "Not Possible";
		
		PriorityQueue<CharFrequency> pq = new PriorityQueue<>(list.size());
		pq.addAll(list);
		CharFrequency pf= null;
		StringBuilder sb = new StringBuilder(20);
		while(pq.peek() != null)
		{
			CharFrequency f = pq.poll();
			sb.append(f.c);
			f.frequency--;
			if(pf != null && pf.frequency>0)
			{
				pq.add(pf);
			}
			pf = f;
		}
		return sb.toString();
	}
	
}
