package DP_Traversal_Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Wiki Link: https://en.wikipedia.org/wiki/Dijkstra's_algorithm
//Links: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

/*
Dijkstra's algorithm (/ˈdaɪkstrəz/ DYKE-strəz) is an algorithm for finding the shortest paths between nodes in a weighted graph, which may represent, for example, road networks. It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three years later.[4][5][6]

The algorithm exists in many variants. Dijkstra's original algorithm found the shortest path between two given nodes,[6] but a more common variant fixes a single node as the "source" node and finds shortest paths from the source to all other nodes in the graph, producing a shortest-path tree.

For a given source node in the graph, the algorithm finds the shortest path between that node and every other.[7]: 196–206  It can also be used for finding the shortest paths from a single node to a single destination node by stopping the algorithm once the shortest path to the destination node has been determined. For example, if the nodes of the graph represent cities and costs of edge paths represent driving distances between pairs of cities connected by a direct road (for simplicity, ignore red lights, stop signs, toll roads and other obstructions), then Dijkstra's algorithm can be used to find the shortest route between one city and all other cities. A widely used application of shortest path algorithms is network routing protocols, most notably IS-IS (Intermediate System to Intermediate System) and OSPF (Open Shortest Path First). It is also employed as a subroutine in other algorithms such as Johnson's.

The Dijkstra algorithm uses labels that are positive integers or real numbers, which are totally ordered. It can be generalized to use any labels that are partially ordered, provided the subsequent labels (a subsequent label is produced when traversing an edge) are monotonically non-decreasing. This generalization is called the generic Dijkstra shortest-path algorithm.[8][9]

Dijkstra's algorithm uses a data structure for storing and querying partial solutions sorted by distance from the start. Dijkstra's original algorithm does not use a min-priority queue and runs in time 

In some fields, artificial intelligence in particular, Dijkstra's algorithm or a variant of it is known as uniform cost search and formulated as an instance of the more general idea of best-first search.[11]
 */

// A Java program for Dijkstra's single source shortest path
// algorithm. The program is for adjacency matrix
// representation of the graph

class ShortestPath {
	// A utility function to find the vertex with minimum
	// distance value, from the set of vertices not yet
	// included in shortest path tree
	static final int V = 9;

	int minDistance(int dist[], Boolean sptSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed distance
	// array
	void printSolution(int dist[]) {
		System.out.println(
				"Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	// Function that implements Dijkstra's single source
	// shortest path algorithm for a graph represented using
	// adjacency matrix representation
	void dijkstra(int graph[][], int src) {
		int dist[] = new int[V]; // The output array.
									// dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in
		// shortest path tree or shortest distance from src
		// to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[]
		// as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set
			// of vertices not yet processed. u is always
			// equal to src in first iteration.
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of
			// the picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet,
				// there is an edge from u to v, and total
				// weight of path from src to v through u is
				// smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v] != 0
						&& dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist);
	}

	// Driver's code
	public static void main(String[] args) {
		/*
		 * Let us create the example graph discussed above
		 */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
				{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPath t = new ShortestPath();

		// Function call
		t.dijkstra(graph, 0);
	}
}

/*
 * Time Complexity: O(V2)
 * Auxiliary Space: O(V)
 * 
 * Notes:
 * 
 * The code calculates the shortest distance but doesn’t calculate the path
 * information. Create a parent array, update the parent array when distance is
 * updated (like prim’s implementation), and use it to show the shortest path
 * from source to different vertices.
 * The code is for undirected graphs, the same Dijkstra function can be used for
 * directed graphs also.
 * The code finds the shortest distances from the source to all vertices. If we
 * are interested only in the shortest distance from the source to a single
 * target, break them for a loop when the picked minimum distance vertex is
 * equal to the target.
 * The time Complexity of the implementation is O(V2). If the input graph is
 * represented using adjacency list, it can be reduced to O(E * log V) with the
 * help of a binary heap. Please see Dijkstra’s Algorithm for Adjacency List
 * Representation for more details.
 * Dijkstra’s algorithm doesn’t work for graphs with negative weight cycles. It
 * may give correct results for a graph with negative edges but you must allow a
 * vertex can be visited multiple times and that version will lose its fast time
 * complexity. For graphs with negative weight edges and cycles, the
 * Bellman-Ford algorithm can be used, we will soon be discussing it as a
 * separate post.
 */

/*
 * Dijkstra’s shortest path algorithm using Heap in O(E logV):
 * For Dijkstra’s algorithm, it is always recommended to use Heap (or priority
 * queue) as the required operations (extract minimum and decrease key) match
 * with the specialty of the heap (or priority queue). However, the problem is,
 * that priority_queue doesn’t support the decrease key. To resolve this
 * problem, do not update a key, but insert one more copy of it. So we allow
 * multiple instances of the same vertex in the priority queue. This approach
 * doesn’t require decreasing key operations and has below important properties.
 * 
 * Whenever the distance of a vertex is reduced, we add one more instance of a
 * vertex in priority_queue. Even if there are multiple instances, we only
 * consider the instance with minimum distance and ignore other instances.
 * The time complexity remains O(E * LogV) as there will be at most O(E)
 * vertices in the priority queue and O(logE) is the same as O(logV)
 * Below is the implementation of the above approach:
 */

class Graph {
	private int V;
	private List<List<iPair>> adj;

	Graph(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	void addEdge(int u, int v, int w) {
		adj.get(u).add(new iPair(v, w));
		adj.get(v).add(new iPair(u, w));
	}

	void shortestPath(int src) {
		PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new iPair(0, src));
		dist[src] = 0;

		while (!pq.isEmpty()) {
			int u = pq.poll().second;

			for (iPair v : adj.get(u)) {
				if (dist[v.first] > dist[u] + v.second) {
					dist[v.first] = dist[u] + v.second;
					pq.add(new iPair(dist[v.first], v.first));
				}
			}
		}

		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	static class iPair {
		int first, second;

		iPair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}

class Main {
	public static void main(String[] args) {
		int V = 9;
		Graph g = new Graph(V);

		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);

		g.shortestPath(0);
	}
}

/*
 * Time Complexity: O(E * logV), Where E is the number of edges and V is the
 * number of vertices.
 * Auxiliary Space: O(V)
 */