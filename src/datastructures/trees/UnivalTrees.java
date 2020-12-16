package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class UnivalTrees {
    /*
    Given a binary tree, find the number of unival subtrees. An unival tree is a tree that has the same value in every node.
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

    static int findSingleValueTrees(TreeNode root) {
        int[] uniValCount = new int[1];
        if (root == null) return uniValCount[0];
        findSingleValueTrees(root, uniValCount);

        return uniValCount[0];
    }

    //Bottom-Up DFS
    private static boolean findSingleValueTrees(TreeNode node, int[] uniValCount) {
        if (node.left == null && node.right == null) {
            uniValCount[0]++;
            return true;
        }

        boolean isUniVal = true;

        if (node.left != null) {
            boolean isLeftUniVal = findSingleValueTrees(node.left, uniValCount);
            if (!isLeftUniVal || node.val != node.left.val) isUniVal = false;
        }

        if (node.right != null) {
            boolean isRightUniVal = findSingleValueTrees(node.right, uniValCount);
            if (!isRightUniVal || node.val != node.right.val) isUniVal = false;
        }

        if (isUniVal) uniValCount[0]++;

        return isUniVal;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,5,5,5,5};
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
        }
        System.out.println(findSingleValueTrees(root));
    }
}
