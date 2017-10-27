package utils.tree;

public class TreeUtil 
{
	private TreeUtil(){}
	public static <T extends Comparable<T>> void inorder(AbstractBinaryTree<T>.Node root)
	{
		if(root != null)
		{
			inorder(root.getLeft());
			System.out.println(root.getData()+" ");
			inorder(root.getRight());
		}
	}
	public static <T extends Comparable<T>> void preorder(AbstractBinaryTree<T>.Node root)
	{
		if(root != null)
		{
			System.out.println(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public static<T extends Comparable<T>> void postorder(AbstractBinaryTree<T>.Node root)
	{
		if(root != null)
		{
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.println(root.getData()+" ");
		}
	}
	public static<T extends Comparable<T>> BstTree<T>.Node getMin(BstTree<T>.Node node)
	{
		if(node == null || node.getLeft() == null)
			return node;
		return getMin(node.getLeft());
	}
	public static<T extends Comparable<T>> BstTree<T>.Node getMax(BstTree<T>.Node node)
	{
		if(node == null ||node.getRight() == null)
			return node;
		return getMax(node.getRight());
	}
}
