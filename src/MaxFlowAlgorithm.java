// Java program for implementation of Ford Fulkerson algorithm

/* References
*  Anon., n.d. [Online]
Available at: https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/?ref=lbp
[Accessed 29 03 2020].

*/

import edu.princeton.cs.introcs.Stopwatch;
import java.lang.*;
import java.util.LinkedList;

public class MaxFlowAlgorithm {

    //Number of vertices in graph
    static int vertices = 0;
    static int instance = 1;

    /* Returns true if there is a path from source 's' to sink
    't' in residual graph. Also fills parent[] to store the
    path */
    boolean bfs(int[][] residualGraph, int s, int t, int[] parent) {
        // Create a visited array and mark all vertices as not
        // visited
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; ++i)
            visited[i] = false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t]);
    }

    // Returns tne maximum flow from s to t in the given graph
    int fordFulkerson(int[][] graph, int s, int t) {
        int u, v;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where residualGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If residualGraph[i][j] is 0, then there is
        // not)
        int[][] residualGraph = new int[vertices][vertices];

        for (u = 0; u < vertices; u++)
            for (v = 0; v < vertices; v++)
                residualGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int[] parent = new int[vertices];

        int max_flow = 0; // There is no flow initially

        // Augment the flow while there is a path from source to sink

        while (bfs(residualGraph, s, t, parent)) {
            // Find minimum residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, residualGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= path_flow;
                residualGraph[v][u] += path_flow;
            }

            // Add path flow to overall flow
            
            System.out.println("flow being added in instance " + instance + " is: " + path_flow);
            instance++;
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;
    }


}

