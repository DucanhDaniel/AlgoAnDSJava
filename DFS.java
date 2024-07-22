package JustSomeAlgo;

import java.util.List;
import java.util.ArrayList;

public class DFS {
    private int numNode;
    private List<List<Pair<Integer, Integer>>> adj;
    private int[] par;
    private int[] dist;
    private List<List<Integer>> dfsTree;

    public DFS(int numNode, List<List<Pair<Integer, Integer>>> adj) {
        this.numNode = numNode;
        this.adj = adj;
    }

    private void dfs(int u) {
        System.out.println(u);
        for (Pair<Integer, Integer> element : adj.get(u)) {
            int v = element.first();
            if (par[v] == -1) {
                par[v] = u;
                dist[v] = dist[u] + 1;
                dfsTree.get(u).add(v);
                dfs(v);
            }
        }
    }

    // Make sure to call this function before calling public methods
    private int savedRoot = -1;

    private void prepare(int startingNode) {
        if (savedRoot == -1 || savedRoot != startingNode) {
            par = new int[numNode + 1];
            dist = new int[numNode + 1];
            dfsTree = new ArrayList<>();
            for (int i = 0; i <= this.numNode; i++) {
                par[i] = -1;
                dist[i] = Integer.MAX_VALUE;
                dfsTree.add(new ArrayList<>());
            }
            dist[startingNode] = 0;
            par[startingNode] = 0;
            dfs(startingNode);
            savedRoot = startingNode;
        }
    }

    // Get the distance from startingNode to endingNode in the dfs tree which has
    // startingNode as root
    public int getDist(int startingNode, int endingNode) {
        prepare(startingNode);
        return dist[endingNode];
    }

    // Get the path from startingNode to endingNode in the dfs tree which has
    // startingNode as root
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

    // Get the dfs tree which has startingNode as root
    public List<List<Integer>> getDFSTree(int startingNode) {
        prepare(startingNode);
        return dfsTree;
    }

}
