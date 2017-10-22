package solutions.tree;

import utils.tree.BstTree;
import utils.tree.TreeUtil;

public class CloestTreeNode 
{
	public static void main(String... a)throws Exception
	{
		BstTree<Integer> tree = new BstTree<Integer>();
		tree.insertWithParent(24);
		tree.insertWithParent(21);
		tree.insertWithParent(30);
		tree.insertWithParent(16);
		tree.insertWithParent(22);
		tree.insertWithParent(10);
		tree.insertWithParent(20);
		tree.insertWithParent(25);
		tree.insertWithParent(34);
		System.out.println(closestNode(tree.getRoot().getRight().getLeft()));
	}
	private static int mod(int a)
	{
		if(a<0)
			a=a*-1;
		return a;
	}
	private static BstTree<Integer>.Node getMinNode(BstTree<Integer>.Node node,BstTree<Integer>.Node a,BstTree<Integer>.Node b)
	{
		if(a == null)
			return b;
		else if(b == null)
			return a;
		else if(mod(node.getData()-a.getData())<mod(node.getData()-b.getData()))
		{
			return a;
		}
		return b;
	}
	public static BstTree<Integer>.Node closestNode(BstTree<Integer>.Node node)
	{
		if(node != null && (node.getLeft() != null || node.getRight() != null || node.getParent() != null))
		{
			if(node.getLeft() != null && node.getRight() != null)
			{
				return getMinNode(node,TreeUtil.getMax(node.getLeft()),TreeUtil.getMin(node.getRight()));
			}
			BstTree<Integer>.Node closest = node.getLeft() != null?TreeUtil.getMax(node.getLeft()):TreeUtil.getMin(node.getRight());
			return closestParentNode(node,closest);
		}
		return null;
	}
	private static boolean isLeftChild(BstTree<Integer>.Node parent,BstTree<Integer>.Node child)
	{
		return parent.getLeft() == child ?true:false;
	}
	private static BstTree<Integer>.Node closestParentNode(BstTree<Integer>.Node node,BstTree<Integer>.Node closest)
	{
		BstTree<Integer>.Node parent = node.getParent();
		if(parent != null)
		{
			closest = getMinNode(node,closest,parent);
			boolean isLeftChild = isLeftChild(parent,node);
			boolean firstChild =  isLeftChild;
			BstTree<Integer>.Node child = node;
			while(parent != null || firstChild == isLeftChild)
			{
				parent = parent.getParent();
				isLeftChild = isLeftChild(parent,child);
				child = parent;
			}
			closest = getMinNode(node,closest,parent);
		}
		return closest;
	}
}
