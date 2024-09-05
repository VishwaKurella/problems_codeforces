import java.util.*;
public class _2010C1 {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        String t = S.nextLine();
        int n = t.length();
        boolean found = false;
        for (int k = 1; k <= n / 2; k++) {
            String firstPart = t.substring(0, n - k);
            String shiftedPart = t.substring(k, n);
            if (firstPart.equals(shiftedPart) && !firstPart.equals(t)) {
                System.out.println("YES");
                System.out.println(firstPart);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("NO");
        }
    }
}