import java.util.*;

public class WallsAndGates {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int[][] result = new int[n][n];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = S.nextInt();
                if (result[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] gate : list) {
            dfs(result, gate[0], gate[1], 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int[][] matrix, int row, int column, int count) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || matrix[row][column] < count) {
            return;
        }
        matrix[row][column] = count;
        dfs(matrix, row + 1, column, count + 1);
        dfs(matrix, row - 1, column, count + 1);
        dfs(matrix, row, column + 1, count + 1);
        dfs(matrix, row, column - 1, count + 1);
    }
}
