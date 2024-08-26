import java.util.*;

class TreeNode {
    int val;
    TreeNode right, left;
    TreeNode() {
        right = null;
        left = null;
    }
    TreeNode(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}

public class BFS {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        if (n == 0) {
            System.out.println("Tree is empty");
            return;
        }
        TreeNode root = new TreeNode(S.nextInt());
        for (int i = 1; i < n; i++) {
            binaryTreeAdd(S.nextInt(), root);
        }
        System.out.println("BFS Traversal:");
        bfs(root);
    }
    static void binaryTreeAdd(int val, TreeNode root) {
        if (val <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                binaryTreeAdd(val, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                binaryTreeAdd(val, root.right);
            }
        }
    }
    static void bfs(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.val+" ");
            if(temp.right != null){
                stack.push(temp.left);
            }
            if(temp.left != null){
                stack.push(temp.right);
            }
        }
    }
}
