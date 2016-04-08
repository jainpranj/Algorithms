package assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Question4 {

	public static void main(String[] args) {
		// // TODO Auto-generated method stub
		// String s = "(A,B) (A,C) (B,G) (G,C) (E,F) (B,D) (C,E)";
		 String s="(B,D) (D,E) (A,B) (C,F) (E,G) (A,C) (E,H) (E,I)";
		String s1=s;
		s1=s1.replaceAll("[^A-Z]", "");
		TreeMap<Character,Integer> map=new TreeMap<Character,Integer>();
		int i1=0;
		char[] ccc=s1.toCharArray();
		Arrays.sort(ccc);
		for(char c:ccc){
			if(map.get(c)==null){
				map.put(c, i1);
				i1++;
			}
		}
		String[] str = s.split(" ");
		Graph graph = new Graph(i1);
		for (String ss : str) {
			ss = ss.replaceAll("[^A-Z]", "");
			char[] c = ss.toCharArray();
			graph.addEdge(map.get(c[0]), map.get(c[1]));
		}
		if(!graph.numberOfChildren(i1)){
			System.out.println("E1");
		}
		else if(!graph.isTree()){
			System.out.println("E3");
		}
	
		else if(graph.isTree()){
			StringBuilder sb=new StringBuilder();
			Boolean visited[] = new Boolean[i1];
			for (int i = 0; i < str.length + 1; i++)
				visited[i] = false;
			System.out.println(graph.lexigraphicalReprentstion(0,visited,sb,map));
		}
		else if(graph.numberOfRoot(i1)){
			System.out.println("E4");
		}
		else{
			System.out.println("E5");
		}

	}

	// This class represents a directed graph using adjacency
	// list representation
	static class Graph {
		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; // Adjacency List
		private LinkedList<Integer> root[];
		// Constructor
		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			root = new LinkedList[v];
			for (int i = 0; i < v; ++i){
				adj[i] = new LinkedList();
			root[i] = new LinkedList();
			}
		}

		// Function to add an edge into the graph
		void addEdge(int v, int w) {
			adj[v].add(w);
			root[w].add(v);
			adj[w].add(v);
		}

		// A recursive function that uses visited[] and parent
		// to detect cycle in subgraph reachable from vertex v.
		Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
			// Mark the current node as visited
			visited[v] = true;
			Integer i;

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> it = adj[v].iterator();
			while (it.hasNext()) {
				i = it.next();

				// If an adjacent is not visited, then recur for
				// that adjacent
				if (!visited[i]) {
					if (isCyclicUtil(i, visited, v))
						return true;
				}

				// If an adjacent is visited and not parent of
				// current vertex, then there is a cycle.
				else if (i != parent)
					return true;
			}
			return false;
		}

		// Returns true if the graph is a tree, else false.
		Boolean isTree() {
			// Mark all the vertices as not visited and not part
			// of recursion stack
			Boolean visited[] = new Boolean[V];
			for (int i = 0; i < V; i++)
				visited[i] = false;

			// The call to isCyclicUtil serves multiple purposes
			// It returns true if graph reachable from vertex 0
			// is cyclcic. It also marks all vertices reachable
			// from 0.
			if (isCyclicUtil(0, visited, -1))
				return false;

			// If we find a vertex which is not reachable from 0
			// (not marked by isCyclicUtil(), then we return false
			for (int u = 0; u < V; u++)
				if (!visited[u])
					return false;

			return true;
		}

		StringBuilder lexigraphicalReprentstion(int v,Boolean visited[], StringBuilder sb,TreeMap<Character,Integer> map) {
//			Boolean visited[] = new Boolean[V];
//			for (int i = 0; i < V; i++)
//				visited[i] = false;
			// Mark the current node as visited
			visited[v] = true;
			Integer i;

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> it = adj[v].iterator();
		
			//char c = (char) (v + 65);
			
		       for ( Character cc: map.keySet()) {
		            if (map.get(cc).equals(v)) {
		            	sb.append("(").append(cc);
		            	break;
		            }
		       }
		
		
			while (it.hasNext()) {
				i = it.next();
				
				
				// If an adjacent is not visited, then recur for
				// that adjacent
				if (!visited[i]) {
					
					lexigraphicalReprentstion(i,visited, sb,map);

				}
		
			}
			sb.append(")");	
				// If an adjacent is visited and not parent of
				// current vertex, then there is a cycle.
return sb;
			}
			
	//	}
	public boolean numberOfChildren(int V){
		for (int u = 0; u < V; u++){
			if(adj[u].size()>2){
				return false;
			}
		}
				
		return true;
		
	}

	public boolean numberOfRoot(int V){
		for (int u = 0; u < V; u++){
			if(root[u].size()>1){
				return false;
			}
		}
				
		return true;
		
	}
	}

}

