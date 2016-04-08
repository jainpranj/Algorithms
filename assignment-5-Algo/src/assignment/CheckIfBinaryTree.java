package assignment;

import java.util.Stack;

public class CheckIfBinaryTree {

	public static void main(String[] args) {
		// // TODO Auto-generated method stub
		String s = "(A,B) (A,C) (B,G) (G,C) (E,F) (B,D) (C,E)";
		String[] str = s.split(" ");
		Graph graph = new Graph(str.length + 1);
		for (String ss : str) {
			ss = ss.replaceAll("[^\\w\\s]", "");
			char[] c = ss.toCharArray();
			graph.addEdge(c[0] - 65, c[1] - 65);
			
			

	}
		validateGraph(graph, str.length);
	}
		public static void validateGraph(Graph graph,int V){
			

			
			//detect cycle in graph
			Cycle finder = new Cycle(graph);
			if (finder.hasCycle()) {
				System.out.println("E3");
				return;
			} else {
				for (int v = 0; v < V+1; v++) {
					// more than 1 root
					
					if (graph.rootNumber(v) > 1) {
						System.out.println("E4");
						return;
					}
					
					// more than 2 children
					if (graph.degree(v) > 2) {
						System.out.println("E1");
						return;
					}

				}
			}
	
		}
	//	System.out.println(graph.toString());
	
	}


