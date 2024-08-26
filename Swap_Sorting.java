import java.util.Scanner;
public class Swap_Sorting {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int A[] = new int [10];

        for(int i =0;i<10;i++){
            System.out.print("Please enter the NUmber: ");
            A[i] = S.nextInt();
        }
        for(int i=0;i<10;i++){
            for(int j=i+1;j<10;j++){
                if(A[i]>A[j]){
                    int temp;
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        for(int i =0;i<10;i++){
            System.out.print(A[i]+" ");
        }
    }
}
