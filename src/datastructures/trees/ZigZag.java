package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ZigZag {
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
        if (currNode == null) { return; }
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

    public static void zigZagTraversal(TreeNode currNode) {
        if (currNode == null) { return; }
        LinkedList<TreeNode> currLevelQ = new LinkedList<>();
        currLevelQ.add(currNode);
        LinkedList<TreeNode> nextLevelQ = new LinkedList<>();

        TreeNode curr;
        boolean leftToRight = true;
        while (!currLevelQ.isEmpty()) {
            if (leftToRight) curr = currLevelQ.poll();
            else curr = currLevelQ.pollLast();

            System.out.print(curr.data + " ");

            if (leftToRight) {
                if (curr.left != null) nextLevelQ.add(curr.left);
                if (curr.right != null) nextLevelQ.add(curr.right);
            } else {
                if (curr.right != null) nextLevelQ.addFirst(curr.right);
                if (curr.left != null) nextLevelQ.addFirst(curr.left);
            }

            if (currLevelQ.isEmpty()) {
                currLevelQ = nextLevelQ;
                nextLevelQ = new LinkedList<>();
                leftToRight = !leftToRight;
            }
        }

    }


    public static void main(String[] args) {
        // 20 15 30 14 18 35 17 19 32
        // 1 2 3 4 5 6 7 8 9 10 11 12 13
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nk[0]));

        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println("");
        System.out.println("Tree elements zigzag traversal: ");
        zigZagTraversal(root);

    }
}
