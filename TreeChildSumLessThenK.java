import java.util.*;

class Node {
    int value;
    Node left, right;
    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class TreeChildSumLessThenK {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        HashMap<Integer, Node> map = new HashMap<>(N);
        HashSet<Integer> set = new HashSet<>();
        Node root = null;
        int E = S.nextInt();
        for (int i = 0; i < E; i++) {
            int parent = S.nextInt();
            int child = S.nextInt();
            Node p = map.getOrDefault(parent, new Node(parent));
            if (p.left == null) {
                p.left = map.getOrDefault(child, new Node(child));
                map.put(child, p.left);
            } else {
                p.right = map.getOrDefault(child, new Node(child));
                map.put(child, p.right);
            }
            map.put(parent, p);
            set.add(child);
        }
        for(Integer i : map.keySet()){
            if(!set.contains(i)){
                root = map.get(i);
                break;
            }
        }
        int result = 0;
        dfs(root,3,result);
        System.out.println(result);
    }
    static int dfs(Node node, int K, int result) {
        if (node == null) return 0;
        int leftSum = dfs(node.left, K, result);
        int rightSum = dfs(node.right, K, result);
        int totalSum = node.value + leftSum + rightSum;
        if (totalSum <= K) {
            result++;
        }
        return totalSum;
    }
}
