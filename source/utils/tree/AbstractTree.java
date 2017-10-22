package utils.tree;


public abstract class AbstractTree <T extends Comparable<T>>
{
	public class Node
	{
		private T data;
		private Node left,right,parent;
		Node(T data)
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
	protected Node root=null;
	public Node getRoot()
	{
		return root;
	}
	public abstract void insert(T data);
	public abstract void insertWithParent(T data);
}
