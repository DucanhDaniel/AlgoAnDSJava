package JustSomeAlgo;
import java.util.PriorityQueue;
import java.util.List;


public class Dijkstra {
    // Dijkstra's algorithm to find the shortest path between two nodes in a graph
    private int numNode;
    List<List<Pair<Integer, Integer>>> adj;

    public Dijkstra(int numNode, List<List<Pair<Integer, Integer>>> adj) {
        this.numNode = numNode;
        this.adj = adj;
    }

    public int[] getDistArr(int startingNode) {
        int[] dist = new int[numNode + 1];
        for (int i = 1; i <= numNode; i++) {
            dist[i] = 1000;
        }
        dist[startingNode] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
        pq.add(new Pair<Integer, Integer>(dist[startingNode], startingNode));
        while(pq.isEmpty() == false) {
            int u = pq.peek().second();
            int distNow = pq.peek().first();
            pq.poll();
            for (Pair<Integer, Integer> element : adj.get(u)) {
                int v = element.first();
                int weight = element.second();
                if (dist[v] > distNow + weight) {
                    dist[v] = distNow + weight;
                    pq.add(new Pair<Integer, Integer>(dist[v], v));
                }
            }
        }

        return dist;
    }
}
