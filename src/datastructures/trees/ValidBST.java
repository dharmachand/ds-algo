package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValidBST {
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


    static class TreeNodeBounded extends TreeNode {
        int maxLeft;
        int maxRight;
        TreeNodeBounded(TreeNode node, int maxLeft, int maxRight) {
            super(node.data, node.left, node.right);
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
        }
    }

    public static TreeNode insertBST(TreeNode currNode, int key) {

        if (currNode == null) {
            currNode = new TreeNode(key);
            return currNode;
        }

        //Do inorder traversal and insert at appropriate place
        if (key < currNode.data) {
            currNode.left = insertBST(currNode.left, key);
        } else {
            currNode.right = insertBST(currNode.right, key);
        }

        return currNode;
    }

    public static TreeNode insert(TreeNode currNode, int key) {

        if (currNode == null) {
            currNode = new TreeNode(key);
            return currNode;
        }

        //Do level traversal and insert
        Queue<TreeNode> q = new LinkedList<>();
        q.add(currNode);

        TreeNode newNode = new TreeNode(key);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.left == null) {
                node.left = newNode;
                break;
            } else {
                q.add(node.left);
            }

            if (node.right == null) {
                node.right = newNode;
                break;
            } else {
                q.add(node.right);
            }
        }

        return currNode;
    }

    public static void inorder(TreeNode currNode) {
        if (currNode == null) { return; }

        inorder(currNode.left);
        System.out.print(currNode.data + " ");
        inorder(currNode.right);
    }

    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode root, int maxLeft, int maxRight) {
        if (root == null) return true;
        if (root.data < maxLeft || root.data > maxRight) return false;

        boolean isValidLeft = isBST(root.left, maxLeft, root.data - 1);
        boolean isValidRight = isBST(root.right, root.data + 1, maxRight);

        return isValidLeft && isValidRight;
    }

    public static boolean isBSTItr(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNodeBounded> q = new LinkedList<>();
        TreeNodeBounded rootBounded = new TreeNodeBounded(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        q.add(rootBounded);

        TreeNodeBounded currNode, newNode;
        while (!q.isEmpty()) {
            currNode = q.poll();
            if (currNode.data < currNode.maxLeft || currNode.data > currNode.maxRight) return false;

            if (currNode.left != null) {
                newNode = new TreeNodeBounded(currNode.left, currNode.maxLeft, currNode.data - 1);
                q.add(newNode);
            }
            if (currNode.right != null) {
                newNode = new TreeNodeBounded(currNode.right, currNode.data + 1, currNode.maxRight);
                q.add(newNode);
            }
        }

        return true;
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        //test case - 1
        TreeNode root = new TreeNode(Integer.parseInt(nk[0]));
        for (int i = 1; i < nk.length; i++) {
            insertBST(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println(" ");
        System.out.println("Tree is BST: " + isBST(root));

        //test case - 2
        root = new TreeNode(Integer.parseInt(nk[0]));
        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println(" ");
        System.out.println("Tree is BST: " + isBST(root));
        System.out.println("Tree is BST (iterative solution): " + isBSTItr(root));

    }
}
