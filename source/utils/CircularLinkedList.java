package utils;

public class CircularLinkedList<T>
{
	public class Node
	{
		private T element;
		private Node next=null;
		public Node(T e)
		{
			element = e;
		}
		public T getElement() 
		{
			return element;
		}
		public void setElement(T element) 
		{
			this.element = element;
		}
		public Node getNext() 
		{
			return next;
		}
		public void setNext(Node next) 
		{
			this.next = next;
		}
	}
	Node head;
	Node tail;
	Node current;
	public CircularLinkedList()
	{
		head = null;
		tail = null;
	}
	public void add(T e)
	{
		Node n = new Node(e);
		if(head == null)
		{
			head = n;
			tail = n;
			tail.setNext(n);
		}
		else
		{
			tail.setNext(n);
			tail = n;
		}
	}
	public boolean isFirstNode()
	{
		return current == head;
	}
	public void remove(T e)
	{
		if(head != null)
		{
			if(head.element.equals(e))
			{
				if(head.equals(tail))
				{
					head = head.next;
					tail.next = head;
				}
				else
				{
					head = tail = null;
				}
			}
			else
			{
				Node pre = head;
				for(Node curr=head.next;curr!= head;curr = curr.next)
				{
					if(curr.element.equals(e))
					{
						pre.next = curr.next;
						break;
					}
					pre = curr;
				}
			}
		}
		
	}
	
	public T next()
	{
		T e=null;
		if(current != null)
		{
			e = current.element;
			current=current.next;
		}
		return e;
	}
	public void addNextToElement(T element,T newElement)
	{
		for(Node curr=head,pre =null;pre != tail;pre = curr,curr = curr.next)
		{
			if(curr.element.equals(element))
			{
				Node n = new Node(newElement);
				n.next = curr.next;
				curr.next=n;
				break;
			}
		}
	}
	public T getElement()
	{
		return current!=null?current.element:null;
	}
}
