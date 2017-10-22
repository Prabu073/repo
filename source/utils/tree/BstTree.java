package utils.tree;

public class BstTree<T extends Comparable<T>>
{
	
	public class Node
	{
		private T data;
		private Node left,right,parent;
		private Node(T data)
		{
			this.data = data;
			left = null;
			right=null;
			parent=null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public String toString()
		{
			return "data="+data;
		}
	}
	private Node root=null;
	
	public Node getRoot()
	{
		return root;
	}
	public void insert(T data)
	{
		root = insertNode(root,data);
	}
	public void insertWithParent(T data)
	{
		if(root == null)
		{
			root = new Node(data);
		}
		else
		{
			Node newNode = new Node(data);
			Node parent = root;
			Node curr = root;
			while(curr!=null)
			{
				parent = curr;
				
				if(curr.getData().compareTo(newNode.getData())>0)
				{
					curr = curr.getLeft();
				}
				else
				{
					curr = curr.getRight();
				}
			}
			if(parent.getData().compareTo(newNode.getData())>0)
			{
				parent.setLeft(newNode);
			}
			else
			{
				parent.setRight(newNode);
			}
			newNode.setParent(parent);
		}
	}
	private Node insertNode(Node node,T data)
	{
		if(node == null)
		{
			return new Node(data);
		}
		else if(node.getData().compareTo(data)>0)
		{
			node.setLeft(insertNode(node.getLeft(),data));
		}
		else
		{
			node.setRight(insertNode(node.getRight(),data));
		}
		return node;
	}
}

