package datastructures.trees;

import java.util.*;

public class MinTreeDepth {
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

    public static int minTreeDepth(TreeNode root) {
        int minDepth = Integer.MAX_VALUE, level = 1;
        if (root == null) return 0;

        Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
        Queue<TreeNode> currentLevelQ = new LinkedList<>();
        Queue<TreeNode> nextLevelQ = new LinkedList<>();
        currentLevelQ.add(root);
        nodeDepthMap.put(root, level);

        TreeNode currNode;
        while (!currentLevelQ.isEmpty()) {
            currNode = currentLevelQ.poll();

            if (currNode.left != null) {
                nextLevelQ.add(currNode.left);
            }

            if (currNode.right != null) {
                nextLevelQ.add(currNode.right);
            }

            if (currentLevelQ.isEmpty()) {
                level++;
                while (!nextLevelQ.isEmpty()) {
                    currNode = nextLevelQ.poll();
                    currentLevelQ.add(currNode);
                    nodeDepthMap.put(currNode, level);
                }
                nextLevelQ = new LinkedList<>();
            }
        }

        for (Map.Entry<TreeNode, Integer> entry : nodeDepthMap.entrySet()) {
            currNode = entry.getKey();
            if (currNode.left == null && currNode.right == null) {
                minDepth = Math.min(minDepth, entry.getValue());
            }
        }

        return minDepth;
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
        int  minDepth = minTreeDepth(root);
        System.out.println("Min Depth of the tree is: " + minDepth);

    }
}
