public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";

        // Normalize input for fair comparison
        String normalized = word.replaceAll("\\s+", "").toLowerCase();

        // Run and time different algorithms
        runAndMeasure("Two-Pointer", () -> isPalindromeTwoPointer(normalized));
        runAndMeasure("Stack-Based", () -> isPalindromeStack(normalized));
        runAndMeasure("Deque-Based", () -> isPalindromeDeque(normalized));
        runAndMeasure("Recursive", () -> isPalindromeRecursive(normalized, 0, normalized.length() - 1));
    }

    // Utility method to measure execution time
    public static void runAndMeasure(String name, RunnableCheck check) {
        long start = System.nanoTime();
        boolean result = check.run();
        long end = System.nanoTime();
        System.out.println(name + " -> " + (result ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end - start) + " ns");
    }

    // Functional interface for algorithm checks
    interface RunnableCheck {
        boolean run();
    }

    // Two-pointer approach
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Stack-based approach
    public static boolean isPalindromeStack(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : str.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        return str.equals(reversed);
    }

    // Deque-based approach
    public static boolean isPalindromeDeque(String str) {
        java.util.Deque<Character> deque = new java.util.LinkedList<>();
        for (char c : str.toCharArray()) deque.add(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // Recursive approach
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}