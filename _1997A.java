import java.util.*;

public class _1997A {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int T = S.nextInt();
        S.nextLine();
        while (T-- > 0) {
            String password = S.nextLine();
            int i = -1;
            for (int k = 0; k < password.length() - 1; k++) {
                if (password.charAt(k) == password.charAt(k + 1)) {
                    i = k;
                }
            }
            if (i == -1) {
                if (password.charAt(password.length() - 1) == 'a') {
                    System.out.println(password + "b");
                } else {
                    System.out.println(password + "a");
                }
            } else {
                if (password.charAt(i) == 'a') {
                    System.out.println(password.substring(0, i + 1) + 'b' + password.substring(i+1));
                } else {
                    System.out.println(password.substring(0, i + 1) + 'a' + password.substring(i+1));
                }
            }
        }
    }
}
