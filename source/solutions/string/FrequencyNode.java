package solutions.string;

import java.util.ArrayList;

public class FrequencyNode 
{
	private int count;
	private ArrayList<String> words;
	private FrequencyNode next,previous;
	FrequencyNode(int count)
	{
		this.count = count;
		words = new ArrayList<>();
		next = null;
		previous = null;
	}
	public FrequencyNode getNext() 
	{
		return next;
	}
	public void setNext(FrequencyNode next) 
	{
		this.next = next;
	}
	public FrequencyNode getPrevious() 
	{
		return previous;
	}
	public void setPrevious(FrequencyNode previous) 
	{
		this.previous = previous;
	}
	public int getCount() 
	{
		return count;
	}
	public void setCount(int count) 
	{
		this.count = count;
	}
	public ArrayList<String> getWords() 
	{
		return words;
	}
	public void addWord(String word)
	{
		words.add(word);
	}
	public void removeWord(String word)
	{
		words.remove(word);
	}
	public String toString()
	{
		return "count = "+count+" words="+words.toString();
	}
}
