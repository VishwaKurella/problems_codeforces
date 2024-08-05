import java.util.*;

public class _158A {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int k = S.nextInt();
        int[] scores = new int[n];
        int result = 0;
        for(int i = 0;i<n;i++){
            scores[i] = S.nextInt();
        }
        int kthScore = scores[k-1];
        for(int i =0;i<n;i++){
            if(scores[i] >= kthScore && scores[i] > 0){
                result++;
            }
        }
        System.out.println(result);
    }
}
