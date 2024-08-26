import java.util.*;

public class SegmentTree {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int[] array = new int[n];
        int[] sum = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = S.nextInt();
        }
        sum[0] = array[0];
        for(int i = 1;i<n;i++){
            sum[i] = array[i] + sum[i-1];
        }
        NodeSegment root = new NodeSegment(0, 0, n - 1);
        buildSegmentTree(root, array, 0, n - 1);
        dfs(root);
    }

    static void buildSegmentTree(NodeSegment root, int[] array, int left, int right){
        if (left > right) {
            return;
        }
        if (left == right) {
            root.sum = array[left];
            return;
        }
        int mid = left + (right - left) / 2;
        root.left = new NodeSegment(0, left, mid);
        root.right = new NodeSegment(0, mid + 1, right);
        buildSegmentTree(root.left, array, left, mid);
        buildSegmentTree(root.right, array, mid + 1, right);
        root.sum = Math.max(root.left.sum, root.right.sum);
    }
    static void dfs(NodeSegment root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        System.out.print(root.sum + " ");
    }
    static void updateSegmentTree(int val, int index, NodeSegment root, int left, int right){
        if (left == right) {
            root.sum = val;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateSegmentTree(val, index, root.left, left, mid);
        } else {
            updateSegmentTree(val, index, root.right, mid + 1, right);
        }
        root.sum = Math.max(root.left.sum, root.right.sum);
    }
}

class NodeSegment{
    int sum;
    int leftInterval, rightInterval;
    NodeSegment left, right;
    NodeSegment(int sum, int leftInterval, int rightInterval){
        this.sum = sum;
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }
}