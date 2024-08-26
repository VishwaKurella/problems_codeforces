import java.util.*;
public class Partial_Sorting {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();
        int A[] = new int [N];
        for(int i =0;i<N;i++){
            System.out.print("Please enter the Number: ");
            A[i] = S.nextInt();
        }
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N-1;j++){
                if(A[j]>A[j+1]){
                    int temp;
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i =0;i<N;i++){
            System.out.print(A[i]+" ");
        }
    }
}