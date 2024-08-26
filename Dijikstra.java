import java.util.*;

class Dijkstra {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        List<List<int[]>> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<int[]>());
        }
        int E = S.nextInt();
        int max = 0;
        while (E-- > 0) {
            int u = S.nextInt();
            int v = S.nextInt();
            int w = S.nextInt();
            max = max + w;
            list.get(u).add(new int[]{v, w});
        }
        int source = S.nextInt();
        int[] result = shortestPath(list, source);
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + " : " + (result[i]>=max ? -1 : result[i]));
        }
    }
    static int[] shortestPath(List<List<int[]>> list, int source) {
        int[] result = new int[list.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        result[source] = 0;
        queue.offer(new int[]{source, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if (currentDistance > result[currentNode]) {
                continue;
            }
            for (int[] neighbor : list.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = result[currentNode] + weight;
                if (newDist < result[nextNode]) {
                    result[nextNode] = newDist;
                    queue.offer(new int[]{nextNode, newDist});
                }
            }
        }
        return result;
    }
}