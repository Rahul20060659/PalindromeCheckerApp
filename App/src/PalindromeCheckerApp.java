public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Hardcoded string literal with spaces and mixed case
        String word = "A man a plan a canal Panama";

        // Normalize string: remove spaces and convert to lowercase
        String normalized = word.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome using two-pointer approach
        if (isPalindrome(normalized)) {
            System.out.println("\"" + word + "\" is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("\"" + word + "\" is not a palindrome.");
        }
    }

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}