package utils.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GraphUtil 
{
	private GraphUtil(){}
	public static<T> List<T> topologicalSort(Graph<T> g)
	{
		Collection<Graph<T>.Vertex> vertices = g.getVertices();
		HashSet<Graph<T>.Vertex>  visited = new HashSet<>();
		Stack<Graph<T>.Vertex> stack = new Stack<>();
		for(Graph<T>.Vertex v : vertices)
		{
			if(!visited.contains(v))
			{
				topologicalSortUtil(visited,stack,v);
			}
		}
		ArrayList<T> list =  new ArrayList<>();
		while(!stack.isEmpty())
		{
			list.add(stack.pop().getData());
		}
		return list;
	}
	private static<T> void topologicalSortUtil(HashSet<Graph<T>.Vertex> visited,Stack<Graph<T>.Vertex> stack,Graph<T>.Vertex vertex)
	{
		visited.add(vertex);
		for(Graph<T>.Vertex v : vertex.getAdjacentVertices())
		{
			if(!visited.contains(v))
			{
				topologicalSortUtil(visited,stack,v);
			}
		}
		stack.push(vertex);
	}
}
