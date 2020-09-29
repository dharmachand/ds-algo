package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LongestUniPath {
    /*
        Given a binary tree, find the length of the longest path where each node in the path has the same value.
        This path may or may not pass through the root.

        The length of path between two nodes is represented by the number of edges between them.
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode insertBST(TreeNode currNode, int key) {

        if (currNode == null) {
            currNode = new TreeNode(key);
            return currNode;
        }

        //Do inorder traversal and insert at appropriate place
        if (key < currNode.val) {
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
        System.out.print(currNode.val + " ");
        inorder(currNode.right);
    }

    private static int res;
    public static int longestUnivaluePath(TreeNode root) {
        res = 0;
        arrowLength(root);
        return res;
    }

    public static int arrowLength(TreeNode node) {
        if (node == null) return 0;

        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val)
            arrowLeft += left + 1;
        if (node.right != null && node.right.val == node.val)
            arrowRight += right + 1;

        res = Math.max(res, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        int[] nums = {5,4,5,1,1,5};
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertBST(root, nums[i]);
        }
        System.out.println(longestUnivaluePath(root));
    }
}
