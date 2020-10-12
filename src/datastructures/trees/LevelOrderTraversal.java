package datastructures.trees;

import java.util.*;

public class LevelOrderTraversal {
    /*
        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

        For example:
        Given binary tree [3,9,20,null,null,15,7]

        Solution:
        https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/114449/A-general-approach-to-level-order-traversal-questions-in-Java
            - Binary Tree Level Order Traversal
            - Binary Tree Level Order Traversal II
            - Binary Tree Zigzag Level Order Traversal
            - Average of Levels in Binary Tree
            - Binary Tree Right Side View
            - Find Largest Value in Each Tree Row
            - Populating Next Right Pointers in Each Node
     */
    public static final Scanner scanner = new Scanner(System.in);

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
        System.out.print(currNode.val + " ");
        inorder(currNode.right);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(ans, root, 0);
        return ans;
    }

    public static void traverse(List<List<Integer>> ans, TreeNode curr, int level) {
        if(curr == null) return;

        if(ans.size() == level)
            ans.add(new ArrayList<>());

        ans.get(level).add(curr.val);

        traverse(ans, curr.left, level + 1);
        traverse(ans, curr.right, level + 1);
    }


    public static void main(String[] args) {

        Integer[] nk = {3,9,20,-1,-1,15,7};

        TreeNode root = new TreeNode(Integer.valueOf(nk[0]));
        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.valueOf(nk[i]));
        }

        System.out.println(levelOrder(root));

    }
}
