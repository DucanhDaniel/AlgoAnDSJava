package JustSomeAlgo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BFSDFSTest {
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
        int endingNode = sc.nextInt();

        BFS bfs = new BFS(numNode, adj);
        System.out.println("Number of edges in the sortest path between S and T is: " + bfs.getMinEdgeDistance(startingNode, endingNode));
        
        int path[] = bfs.getPath(startingNode, endingNode).clone();
        System.out.println("Path from S to T: ");
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();


        DFS dfs = new DFS(numNode, adj);
        System.out.println("Path from S to T in DFS tree:"); 
        path = dfs.getPath(startingNode, endingNode).clone();
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();

    }
}
