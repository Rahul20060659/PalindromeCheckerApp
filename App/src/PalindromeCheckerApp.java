public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Hardcoded string literal
        String word = "radar";

        // Check palindrome using recursion
        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int left, int right) {
        // Base condition: if pointers cross or meet
        if (left >= right) {
            return true;
        }

        // If mismatch found
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursive call: move inward
        return isPalindrome(str, left + 1, right - 1);
    }
}