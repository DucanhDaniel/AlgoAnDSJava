package JustSomeAlgo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DijkstraTest {
    public static void test(String[] args) {
        Scanner sc = ScannerUtils.getScanner();
        int numNode = sc.nextInt();
        int numEdge = sc.nextInt();
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>(numNode + 1);
        for (int i = 1; i <= numNode + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= numEdge; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            adj.get(u).add(new Pair<Integer, Integer>(v, w));
            adj.get(v).add(new Pair<Integer, Integer>(u, w));
        }

        int startingNode = sc.nextInt();

        Dijkstra dijkstra = new Dijkstra(numNode, adj);
        int[] dist = dijkstra.getDistArr(startingNode);

        for (int i = 1; i <= numNode; i++) {
            System.out.println("Distance from stating node " + startingNode + " to node " + i + " is: " + dist[i]);
        }

    }
}
