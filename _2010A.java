import java.util.*;

public class _2010A {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int T = S.nextInt();
        while(T-- > 0){
            int N = S.nextInt();
            int sum = 0;
            int sign = 1;
            while(N-->0){
                sum = sum + (sign*S.nextInt());
                sign = -sign;
            }
            System.out.println(sum);
        }
    }
}
