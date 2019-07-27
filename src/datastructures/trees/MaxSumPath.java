package datastructures.trees;

import java.util.*;

public class MaxSumPath {
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

    public static void insert(TreeNode currNode, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currNode);

        //Do Level Order traversal or Breadth First traversal and insert at empty place
        while (!queue.isEmpty()) {
            currNode = queue.peek();
            queue.remove();

            if (currNode.left == null) {
                currNode.left = new TreeNode(key);
                break;
            } else {
                queue.add(currNode.left);
            }

            if (currNode.right == null) {
                currNode.right = new TreeNode(key);
                break;
            } else {
                queue.add(currNode.right);
            }
        }
    }

    public static void inorder(TreeNode currNode) {
        if (currNode == null) { return; }

        inorder(currNode.left);
        System.out.print(currNode.data + " ");
        inorder(currNode.right);
    }

    public static int maxSumPath(TreeNode root) {
        int[] maxRecursiveHolder = new int[1];
        maxSumPath(root, maxRecursiveHolder);
        return maxRecursiveHolder[0];
    }

    public static int  maxSumPath(TreeNode root, int[] maxRecursiveHolder) {
        if (root == null) return 0;

        int leftSum = maxSumPath(root.left, maxRecursiveHolder);
        int rightSum = maxSumPath(root.right, maxRecursiveHolder);

        int nodeCumVal = Math.max(root.data + leftSum, root.data + rightSum);

        maxRecursiveHolder[0] = Math.max(maxRecursiveHolder[0], leftSum + root.data + rightSum);

        return nodeCumVal;

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
        int  maxSumPath = maxSumPath(root);
        System.out.println("Max sum of the path between 2 nodes of the tree is: " + maxSumPath);

    }
}
