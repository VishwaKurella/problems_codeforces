import java.util.*;

public class _282A {
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        S.nextLine();
        String[] operations = new String[n];
        for(int i = 0;i<n;i++){
            operations[i] = S.nextLine();
        }
        System.out.println(performOperations(operations));
    }
    static int performOperations(String[] operations){
        int i = 0;
        for(String s : operations){
            switch (s){
                case "++X":
                    ++i;
                    break;
                case "X++":
                    i++;
                    break;
                case "--X":
                    --i;
                    break;
                case "X--":
                    break;
            }
        }
        return i;
    }
}
