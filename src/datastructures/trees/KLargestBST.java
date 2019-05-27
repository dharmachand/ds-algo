package datastructures.trees;

import java.util.Scanner;

public class KLargestBST {
    public static final Scanner scanner = new Scanner(System.in);

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        TreeNode(int data) {
            this.data = data;
        }

    }

    public static TreeNode insert(TreeNode currNode, int key) {

        if (currNode == null) {
            currNode = new TreeNode(key);
            return currNode;
        }

        //Do inorder traversal and insert at appropriate place
        if (key < currNode.data) {
            currNode.left = insert(currNode.left, key);
        } else {
            currNode.right = insert(currNode.right, key);
        }

        return currNode;
    }

    public static void inorder(TreeNode currNode) {
        if (currNode == null) { return; }

        inorder(currNode.left);
        System.out.print(currNode.data + " ");
        inorder(currNode.right);
    }

    public static TreeNode findKthLargest(TreeNode root, int k) {
        if (root == null) return null;

        int rightSubTreeSize = findTreeSize(root.right);

        if (k == rightSubTreeSize + 1) return root;
        else if (k < rightSubTreeSize + 1) return findKthLargest(root.right, k);
        else return findKthLargest(root.left, k - rightSubTreeSize - 1);

    }

    public static int findTreeSize(TreeNode root) {
        if (root == null) return 0;

        return findTreeSize(root.left) + findTreeSize(root.right) + 1;
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nk[0]));

        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println(" ");
        System.out.println("Enter K (largest element) to find: ");
        int k = Integer.parseInt(scanner.nextLine());

        TreeNode kLargestNode = findKthLargest(root, k);
        System.out.println("Kth largest element is: " + kLargestNode.data);

    }
}
