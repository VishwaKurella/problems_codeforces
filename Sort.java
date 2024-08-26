
import java.util.Scanner;

class Sort {
    public static void main(String[] args) {
        Scanner S =new Scanner(System.in);
        System.out.println("Enter a string as an input to check whether it is palindrome or not");
        String input = S.nextLine();
        String[] words=input.split("\\s");
        for(String w:words) {
            if (isPalindrome(w)) {
                System.out.println(w + " is a palindrome string");
            } else {
                System.out.println(w + " is not a palindrome string");
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}