package Day6.Level2;
import java.util.Scanner;

class PalindromeChecker {
    String text;
    String rev;

    PalindromeChecker(String text) {
        this.text = text;
        this.rev = "";
    }

    void check() {
        rev = ""; // Use instance variable
        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }
        System.out.println("Reversed String: " + rev);
    }

    void seeResult() {
        if (text.equals(rev)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}

public class palindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();
        PalindromeChecker palindrome = new PalindromeChecker(text);
        palindrome.check();
        palindrome.seeResult();
        sc.close();
    }
}
