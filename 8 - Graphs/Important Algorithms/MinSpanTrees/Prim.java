package MinSpanTrees;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Link: https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

/*
Introduction to Prim’s algorithm:
We have discussed Kruskal’s algorithm for Minimum Spanning Tree. Like Kruskal’s algorithm, Prim’s algorithm is also a Greedy algorithm. This algorithm always starts with a single node and moves through several adjacent nodes, in order to explore all of the connected edges along the way.
 */

/*
How does Prim’s Algorithm Work? 
The working of Prim’s algorithm can be described by using the following steps:
Step 1: Determine an arbitrary vertex as the starting vertex of the MST.
Step 2: Follow steps 3 to 5 till there are vertices that are not included in the MST (known as fringe vertex).
Step 3: Find edges connecting any tree vertex with the fringe vertices.
Step 4: Find the minimum among these edges.
Step 5: Add the chosen edge to the MST if it does not form any cycle.
Step 6: Return the MST and exit
 */

/*
How to implement Prim’s Algorithm?
Follow the given steps to utilize the Prim’s Algorithm mentioned above for finding MST of a graph:

Create a set mstSet that keeps track of vertices already included in MST. 
Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign the key value as 0 for the first vertex so that it is picked first. 
While mstSet doesn’t include all vertices 
Pick a vertex u that is not there in mstSet and has a minimum key value. 
Include u in the mstSet. 
Update the key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. 
For every adjacent vertex v, if the weight of edge u-v is less than the previous key value of v, update the key value as the weight of u-v.
The idea of using key values is to pick the minimum weight edge from the cut. The key values are used only for vertices that are not yet included in MST, the key value for these vertices indicates the minimum weight edges connecting them to the set of vertices included in MST.
 */

/*
Advantages:
Prim’s algorithm is guaranteed to find the MST in a connected, weighted graph.
It has a time complexity of O(E log V) using a binary heap or Fibonacci heap, where E is the number of edges and V is the number of vertices.
It is a relatively simple algorithm to understand and implement compared to some other MST algorithms.

Disadvantages:
Like Kruskal’s algorithm, Prim’s algorithm can be slow on dense graphs with many edges, as it requires iterating over all edges at least once.
Prim’s algorithm relies on a priority queue, which can take up extra memory and slow down the algorithm on very large graphs.
The choice of starting node can affect the MST output, which may not be desirable in some applications.
 */


// A Java program for Prim's Minimum Spanning Tree (MST)
// algorithm. The program is for adjacency matrix
// representation of the graph

/*
Time Complexity: O(V2), If the input graph is represented using an adjacency list, then the time complexity of Prim’s algorithm can be reduced to O(E * logV) with the help of a binary heap.  In this implementation, we are always considering the spanning tree to start from the root of the graph
Auxiliary Space: O(V)
 */

class MST {

	// Number of vertices in the graph
	private static final int V = 5;

	// A utility function to find the vertex with minimum
	// key value, from the set of vertices not yet included
	// in MST
	int minKey(int key[], Boolean mstSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed MST
	// stored in parent[]
	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t"
							+ graph[i][parent[i]]);
	}

	// Function to construct and print MST for a graph
	// represented using adjacency matrix representation
	void primMST(int graph[][])
	{
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in
		// cut
		int key[] = new int[V];

		// To represent set of vertices included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		// Make key 0 so that this vertex is
		// picked as first vertex
		key[0] = 0;
	
		// First node is always root of MST
		parent[0] = -1;

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			
			// Pick the minimum key vertex from the set of
			// vertices not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the
			// adjacent vertices of the picked vertex.
			// Consider only those vertices which are not
			// yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent
				// vertices of m mstSet[v] is false for
				// vertices not yet included in MST Update
				// the key only if graph[u][v] is smaller
				// than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false
					&& graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		// Print the constructed MST
		printMST(parent, graph);
	}

	public static void main(String[] args)
	{
		MST t = new MST();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

		// Print the solution
		t.primMST(graph);
	}
}

// A Java program for Prim's Minimum Spanning Tree (MST)
// algorithm. The program is for adjacency list
// representation of the graph

/*
Time Complexity: O(E*log(E)) where E is the number of edges
Auxiliary Space: O(V^2) where V is the number of vertex
 */

// Class to form pair
class Pair implements Comparable<Pair>
{
	int v;
	int wt;
	Pair(int v,int wt)
	{
		this.v=v;
		this.wt=wt;
	}
	public int compareTo(Pair that)
	{
		return this.wt-that.wt;
	}
}

class GFG {

// Function of spanning tree
static int spanningTree(int V, int E, int edges[][])
	{
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<V;i++)
		{
			adj.add(new ArrayList<Pair>());
		}
		for(int i=0;i<edges.length;i++)
		{
			int u=edges[i][0];
			int v=edges[i][1];
			int wt=edges[i][2];
			adj.get(u).add(new Pair(v,wt));
			adj.get(v).add(new Pair(u,wt));
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0,0));
		int[] vis=new int[V];
		int s=0;
		while(!pq.isEmpty())
		{
			Pair node=pq.poll();
			int v=node.v;
			int wt=node.wt;
			if(vis[v]==1)
			continue;
			
			s+=wt;
			vis[v]=1;
			for(Pair it:adj.get(v))
			{
				if(vis[it.v]==0)
				{
					pq.add(new Pair(it.v,it.wt));
				}
			}
		}
		return s;
	}
	
	// Driver code
	public static void main (String[] args) {
		int graph[][] = new int[][] {{0,1,5},
									{1,2,3},
									{0,2,1}};

		// Function call
		System.out.println(spanningTree(3,3,graph));
	}
}