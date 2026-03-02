// PalindromeStrategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return normalized.equals(reversed);
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        java.util.Deque<Character> deque = new java.util.LinkedList<>();

        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class that uses a strategy
class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Main application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "Racecar";

        // Choose strategy dynamically
        PalindromeChecker checker1 = new PalindromeChecker(new StackStrategy());
        PalindromeChecker checker2 = new PalindromeChecker(new DequeStrategy());

        System.out.println("Using StackStrategy:");
        System.out.println(word + " -> " + (checker1.check(word) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using DequeStrategy:");
        System.out.println(word + " -> " + (checker2.check(word) ? "Palindrome" : "Not Palindrome"));
    }
}