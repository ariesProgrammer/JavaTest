import java.util.*;


import java.util.Scanner;

class JavaTest {

    // 1. Reverse an array using loops
    public static int[] reverseArray(int[] arr) {
        //int[] arr = {3, 1, 4, 1, 5, 9};
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {

            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }

    // 2. Sort an array using Bubble Sort
    public static int[] bubbleSort(int[] arr) {

        boolean sorted = false;

        for(int i=0; i<arr.length-1; i++){

            for(int j=0; j<arr.length-1-i; j++){

                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    sorted = true;
                }
            }

            if(!sorted){

                break;
            }
        }

        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i]);
            System.out.println();
        }

        return arr;
    }

    // 3. Compute factorial using recursion
    public static int factorial(int n) {
        int num = 0, product = 1;

        int total = 0;
        for (int i = 1; i < n; i++) {
            num = n - i;
            product = product * num;

            total = product * n;
        }

        return total;
    }

    // 4. Check if a string is a palindrome
    // Palindrome: a word, phrase, or sequence that reads the same backwards as forwards, e.g. madam or nurses run.
    public static boolean isPalindrome(String str) {
        String newStr = "";
        boolean palindrome = false;
        char[] charStr = str.toCharArray();

        for(int i=0; i<charStr.length-1; i++){

            for(int j=0; j<charStr.length-1-i; j++){
                char temp = charStr[j];
                charStr[j] = charStr[j+1];
                charStr[j+1] = temp;
            }
        }
        newStr = new String(charStr);
        System.out.print(newStr);
        System.out.println();

        if(newStr.equals(str)){
            palindrome = true;
        }

        return palindrome;
    }

    // 5. Find the second largest number in an array
    public static int secondLargest(int[] arr) {
        //int[] arr = {3, 1, 4, 1, 5, 9};
        //int[] arr = {18, 5, 2, 9, 1, 3};
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < firstLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    // 6. Check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

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


    // In-order traversal to get sorted elements from the BST
    public static void inOrderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root == null) return;
        inOrderTraversal(root.left, sortedList);
        sortedList.add(root.val);
        inOrderTraversal(root.right, sortedList);
    }

    public static List<Integer> treeSort(int[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<>();

        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            treeInsert(root, arr[i]);
        }

        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return sortedList;
    }

    // 8. Find the nth Fibonacci number using recursion
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 9. Find the lowest common ancestor (LCA) in a BST
    public static TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (p < root.val && q < root.val) {
            return findLCA(root.left, p, q);
        }
        if (p > root.val && q > root.val) {
            return findLCA(root.right, p, q);
        }
        return root; // If one is on the left and one is on the right, root is the LCA
    }

    // 10. Check if a binary tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    // Helper function to check the balance of the tree
    public static int checkBalance(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 11. Calculate maximum profit
    public static int maxProfit(int[] prices){
        int maxValue = Integer.MAX_VALUE, minValue = Integer.MIN_VALUE;
        int result = 0;

        // {3,1,5,1,2}

        for(int i=0; i<prices.length-1; i++){

            for(int j=0; j<prices.length-1; j++){
                if(prices[j] > prices[j+1]){
                    maxValue = prices[j];
                }else{
                    minValue = prices[j];
                }
            }

        }


        System.out.println("MAXVALUE: " +maxValue+ " and MINVALUE: " +minValue);
        result = maxValue - minValue;


        return result;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = {3, 1, 4, 1, 5, 9};

        System.out.println("Reversed Array: " + Arrays.toString(reverseArray(arr.clone())));
        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(bubbleSort(arr.clone())));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Second largest number: " + secondLargest(arr));
        System.out.println("Is 29 prime? " + isPrime(29));

        System.out.println("Please enter maximum array length");
        int n = scan.nextInt();
        int[] prices = new int[n];
        System.out.println("Please enter array elements");

        for(int i=0; i<prices.length; i++){
            prices[i] = scan.nextInt();
        }

        System.out.println(Arrays.toString(prices));
        System.out.println("Maximum profit: " + maxProfit(prices));



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
