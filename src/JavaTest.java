import java.util.*;

class JavaTest {

    // 1. Reverse an array using loops
    public static int[] reverseArray(int[] arr) {

        return arr;
    }

    // 2. Sort an array using Bubble Sort
    public static int[] bubbleSort(int[] arr) {
        return arr;
    }

    // 3. Compute factorial using recursion
    public static int factorial(int n) {
        return 0;
    }

    // 4. Check if a string is a palindrome
    // Palindrome: a word, phrase, or sequence that reads the same backwards as forwards, e.g. madam or nurses run.
    public static boolean isPalindrome(String str) {
        return true;
    }

    // 5. Find the second largest number in an array
    public static int secondLargest(int[] arr) {
        return 0;
    }

    // 6. Check if a number is prime
    public static boolean isPrime(int num) {
        return true;
    }

    // 7. Sort numbers using TreeSort (BST)
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static void treeInsert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            else treeInsert(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else treeInsert(root.right, val);
        }
    }

    public static List<Integer> treeSort(int[] arr) {
        return new ArrayList<Integer>();
    }

    // 8. Find the nth Fibonacci number using recursion
    public static int fibonacci(int n) {
        return 0;
    }

    // 9. Find the lowest common ancestor (LCA) in a BST
    public static TreeNode findLCA(TreeNode root, int p, int q) {
        return root;
    }

    // 10. Check if a binary tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9};

        System.out.println("Reversed Array: " + Arrays.toString(reverseArray(arr.clone())));
        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(bubbleSort(arr.clone())));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Second largest number: " + secondLargest(arr));
        System.out.println("Is 29 prime? " + isPrime(29));

        List<Integer> treeSorted = treeSort(arr.clone());
        System.out.println("Sorted Array (Tree Sort): " + treeSorted);

        System.out.println("Fibonacci(10): " + fibonacci(10));

        // Creating BST for LCA test
        TreeNode root = new TreeNode(6);
        treeInsert(root, 2);
        treeInsert(root, 8);
        treeInsert(root, 0);
        treeInsert(root, 4);
        treeInsert(root, 7);
        treeInsert(root, 9);
        treeInsert(root, 3);
        treeInsert(root, 5);

        System.out.println("LCA of 2 and 8: " + findLCA(root, 2, 8).val);
        System.out.println("Is tree balanced? " + isBalanced(root));
    }
}
