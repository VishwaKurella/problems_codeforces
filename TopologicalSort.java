import java.util.*;

class NodeT{
    int value;
    boolean visited;
    List<NodeT> children;
    NodeT(int value){
        this.value = value;
        children = new ArrayList<>();
        visited = false;
    }
}

public class TopologicalSort {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        int E = S.nextInt();
        HashMap<Integer,NodeT> map = new HashMap<>(N);
        while(E-->0){
            int parent = S.nextInt();
            int child = S.nextInt();
            NodeT p = map.getOrDefault(parent,new NodeT(parent));
            NodeT c = map.getOrDefault(child,new NodeT(child));
            if(!p.children.contains(c)){
                p.children.add(c);
            }
            map.put(parent,p);
            map.put(child,c);
        }
        Stack<Integer> stack = new Stack<>();
        for(NodeT node : map.values()){
            dfs(node,stack);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
    static void dfs(NodeT node, Stack<Integer> stack) {
        node.visited = true;
        for (NodeT child : node.children) {
            if (!child.visited) {
                dfs(child, stack);
            }
        }
        stack.push(node.value);
    }
}
