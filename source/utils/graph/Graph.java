package utils.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph<T> 
{
	private boolean isDirectional;
	private HashMap<T,Vertex> vertices;
	public Graph(boolean isDirectional)
	{
		this.isDirectional = isDirectional;
		vertices = new HashMap<>();
	}
	public boolean isDirectional()
	{
		return isDirectional;
	}
	public Vertex addVertex(T data)
	{
		Vertex v = vertices.get(data);
		if(v == null)
		{
			v = new Vertex(data);
			vertices.put(data,v);
		}
		return v;
	}
	public void addEdge(T data1,T data2)
	{
		Vertex v1 = addVertex(data1);
		Vertex v2 = addVertex(data2);
		Edge e = new Edge(v1,v2);
		v1.addDetails(v2, e);
		if(!isDirectional)
			v2.addDetails(v1,e);
	}
	public Collection<Graph<T>.Vertex> getVertices()
	{
		return vertices.values();
	}
	public class Edge
	{
		private int weight;
		private Vertex v1,v2;
		public Edge(Vertex v1,Vertex v2)
		{
			this.v1 = v1;
			this.v2 = v2;
			weight = 0;
		}
		public Edge(Vertex v1,Vertex v2,int weight)
		{
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		public int getWeight()
		{
			return weight;
		}
		public Vertex getV1()
		{
			return v1;
		}
		public Vertex getV2()
		{
			return v2;
		}
	}
	public class Vertex
	{
		private T data;
		private ArrayList<Vertex> adjacentVertices = new ArrayList<>();
		private ArrayList<Edge> edges = new ArrayList<>();
		Vertex(T data)
		{
			this.data = data;
		}
		public T getData() 
		{
			return data;
		}
		public ArrayList<Vertex> getAdjacentVertices() 
		{
			return adjacentVertices;
		}
		public ArrayList<Edge> getEdges() 
		{
			return edges;
		}
		public void addDetails(Vertex adjacentVertex, Edge e)
		{
			adjacentVertices.add(adjacentVertex);
			edges.add(e);
		}
	}
}
