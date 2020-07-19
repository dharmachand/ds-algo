package datastructures.trees;

import java.util.Scanner;

public class Diameter {
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
    static int res = 0;
    public static int diameter(TreeNode root) {
        depth(root);
        return res;
    }

    private static int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        // 20 15 30 14 18 35 17 19 32

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nk[0]));

        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println(" ");
        int  diameter = diameter(root);
        System.out.println("Diameter - number of nodes on the longest path between two leaves in the tree is: " + diameter);

    }
}
