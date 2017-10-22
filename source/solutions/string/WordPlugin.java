package solutions.string;

import java.util.HashMap;

public class WordPlugin 
{
	HashMap<String,FrequencyNode> map = new HashMap<>();
	FrequencyNode head = null,tail=null;
	public void addWord(String word)
	{
		FrequencyNode f = map.get(word);
		int count=1;
		if(f!= null)
		{
			count = f.getCount()+1;
			FrequencyNode newF;
			f.removeWord(word);
			if(f.getPrevious() != null && f.getPrevious().getCount()==count)
			{
				newF = f.getPrevious();
			}
			else
			{
				newF= new FrequencyNode(count);
				if(f.getPrevious() == null)
				{
					head = newF;
				}
				if(f.getNext() == null)
				{
					tail = newF;
				}
				newF.setPrevious(f.getPrevious());
				f.setPrevious(newF);
				if(newF.getPrevious() != null)
				{
					newF.getPrevious().setNext(newF);
				}
				newF.setNext(f);
			}
			if(f.getWords().size()==0)
			{
				if(f == head)
				{
					head = f.getNext();
					head.setPrevious(null);
				}
				if(f==tail)
				{
					tail = f.getPrevious();
					tail.setNext(null);
				}
				if(f.getNext() != null)
				f.getNext().setPrevious(f.getPrevious());
				if(f.getPrevious()!=null)
				f.getPrevious().setNext(f.getNext());
				
			}
			f = newF;
		}
		else
		{
			if(head == null)
			{
				f= new FrequencyNode(count);
				head = f;
				tail = f;
			}
			else
			{
				if(tail.getCount() == count)
				{
					f = tail;
				}
				else
				{
					f= new FrequencyNode(count);
					f.setPrevious(tail);
					tail.setNext(f);
					tail = f;
				}
			}
		}
		f.addWord(word);
		map.put(word, f);
	}
	
	public String toString()
	{
		String str="";
		for(FrequencyNode a = head ;  a!=null ;a=a.getNext())
		{
			str+="\n"+a.toString();
		}
		return str;
	}
	public static void main(String... a)throws Exception
	{
		WordPlugin wp = new WordPlugin();
		String[] words = {"sacred","sacred","barbershop","film","neck","decade","decade","neck","sacred","moment","moment","sound","sound","sound","sound","film","film","film"};
		for(String word : words)
		{
			wp.addWord(word);
		}
		System.out.println(wp.toString());
		wp.addWord("film");
		System.out.println(wp.toString());
		wp.addWord("barbershop");
		System.out.println(wp.toString());
	}
	public String[] getTop10Word()
	{
		return null;
	}
}
