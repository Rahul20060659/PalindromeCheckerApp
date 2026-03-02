public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Hardcoded string literal
        String word = "radar";

        // Convert string to character array
        char[] charArray = word.toCharArray();

        // Two-pointer approach
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}