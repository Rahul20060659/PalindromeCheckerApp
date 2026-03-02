public class PalindromeCheckerApp {

    // Node definition for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        String word = "level";

        // Convert string to linked list
        Node head = buildLinkedList(word);

        // Check if linked list is palindrome
        if (isPalindrome(head)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }

    // Build linked list from string
    public static Node buildLinkedList(String str) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Check palindrome using fast & slow pointer + reversal
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow);

        // Compare first half and reversed second half
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // Reverse linked list in-place
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}