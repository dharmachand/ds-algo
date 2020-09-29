package datastructures.trees;

import java.util.*;

public class UniqueBSTs {
    /*
        Given n, Return structurally unique BST's (binary search trees) that store values 1 ... n?
        Explanation:
        Given n = 3, there are a total of 5 unique BST's:

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3
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

    public static void preorder(TreeNode currNode) {
        if (currNode == null) {
            System.out.print(" null ");
            return;
        }

        System.out.print(currNode.val + " ");
        preorder(currNode.left);
        preorder(currNode.right);
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return Arrays.asList();
        return genTrees(1, n);
    }

    private static List<TreeNode> genTrees (int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if(start > end) {
            list.add(null);
            return list;
        }

        if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for(int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for(TreeNode lNode: left) {
                for(TreeNode rNode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        generateTrees(3).forEach(root -> {
            preorder(root);
            System.out.println("");
        });
    }
}
