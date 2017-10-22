package solutions.graph;

import utils.graph.Graph;
import utils.graph.GraphUtil;

public class TravelOrderSourceToDestination 
{
	public static void main(String... strings)throws Exception
	{
		Graph<String> g = new Graph<String>(true);
		g.addEdge("Chennai","Bombay");
		g.addEdge("Bangalore","Goa");
		g.addEdge("Agra","Chennai");
		g.addEdge("Bombay","Bangalore");
		System.out.println(GraphUtil.topologicalSort(g));
	}
}
