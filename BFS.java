package JustSomeAlgo;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BFS {
    private int numNode;
    private List<List<Pair<Integer, Integer>>> adj;

    public BFS(int numNode, List<List<Pair<Integer, Integer>>> adj) {
        this.numNode = numNode;
        this.adj = adj;
    }

    private int[] par;
    private int[] dist;
    private int savedRoot = -1;

    private void bfs(int startingNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        while (queue.isEmpty() == false) {
            int u = queue.peek();
            queue.poll();
            for (Pair<Integer, Integer> element : adj.get(u)) {
                int v = element.first();
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] + 1;
                    par[v] = u;
                    queue.add(v);
                }
            }
        }
    }

    /**
     * Prepares the BFS algorithm for a given starting node.
     * If the starting node is different from the previously saved root,
     * it initializes the distance and parent arrays, runs the BFS algorithm,
     * and updates the saved root.
     *
     * @param startingNode The node from which the BFS algorithm will start.
     */
    private void prepare(int startingNode) {
        if (savedRoot == -1 || savedRoot != startingNode) {
            dist = new int[numNode + 1];
            par = new int[numNode + 1];
            for (int i = 1; i <= numNode; i++) {
                dist[i] = Integer.MAX_VALUE;
                par[i] = -1;
            }
            par[startingNode] = 0;
            dist[startingNode] = 0;
            bfs(startingNode);
            savedRoot = startingNode;
        }
    }

    // Get the minimum edge distance from startingNode to endingNode in the given
    // graph
    public int getMinEdgeDistance(int startingNode, int endingNode) {
        prepare(startingNode);
        return (dist[endingNode] == Integer.MAX_VALUE ? -1 : dist[endingNode]);
    }

    // Get the best path from startingNode to endingNode in the given graph
    public int[] getPath(int startingNode, int endingNode) {
        prepare(startingNode);
        int[] path = new int[dist[endingNode] + 1];
        for (int i = dist[endingNode]; i >= 0; i--) {
            path[i] = endingNode;
            if (endingNode != startingNode)
                endingNode = par[endingNode];
        }
        return path;
    }

    // Get the bfs tree which has startingNode as root
    public List<List<Integer>> getBFSTree(int startingNode) {
        prepare(startingNode);
        List<List<Integer>> bfsTree = new ArrayList<>(numNode + 1);
        for (int i = 1; i <= numNode + 1; i++)
            bfsTree.add(new ArrayList<>());

        for (int i = 1; i <= numNode; i++) {
            if (par[i] != -1) {
                bfsTree.get(par[i]).add(i);
            }
        }
        return bfsTree;
    }
}
