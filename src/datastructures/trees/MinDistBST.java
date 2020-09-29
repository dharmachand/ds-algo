package datastructures.trees;

import java.util.*;

public class MinDistBST {

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

    private static Integer res = Integer.MAX_VALUE, pre = null;
    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 1, 3};
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertBST(root, nums[i]);
        }
        System.out.println(minDiffInBST(root));
    }
}
