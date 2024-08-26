import java.util.*;

public class BellmanFord {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        int E = S.nextInt();
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < E; i++){
            int u = S.nextInt();
            int v = S.nextInt();
            int w = S.nextInt();
            edges.add(new int[]{u, v, w});
        }
        int source = S.nextInt();
        int[] result = shortestPath(edges, N, source);
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + " : " + "Unreachable");
            } else {
                System.out.println("Node " + i + " : " + result[i]);
            }
        }
    }
    static int[] shortestPath(List<int[]> edges, int N, int source) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return new int[]{};
            }
        }
        return distance;
    }
}