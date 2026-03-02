public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Create an instance of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        // Hardcoded string literal
        String word = "Madam";

        // Call the encapsulated method
        if (checker.checkPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}

// Encapsulated PalindromeChecker class
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {
        // Normalize input (case-insensitive, ignore spaces)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Two-pointer approach
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}