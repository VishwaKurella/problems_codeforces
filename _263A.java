import java.util.*;

public class _263A {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int i, j = 0;
        boolean found = false;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(S.nextInt()==1){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        System.out.println(Math.abs(i-2)+Math.abs(j-2));
    }
}
