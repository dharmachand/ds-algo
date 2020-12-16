package datastructures.trees;

public class Diameter {

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
    public static int diameter(TreeNode root) {
        if (root == null) return 0;
        return diameter(root, new int[1]);
    }

    //Bottom-Up DFS
    private static int diameter(TreeNode node, int[] maxDiameter) {
        if (node.left == null && node.right == null) return 0;
        int left = 0, right = 0, myDia = 0;
        if (node.left != null) {
            left = diameter(node.left, maxDiameter);
            myDia += left + 1;
        }
        if (node.right != null) {
            right = diameter(node.right, maxDiameter);
            myDia += right + 1;
        }
        maxDiameter[0] = Math.max(maxDiameter[0], myDia);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        int[] nk = {20, 15, 30, 14, 18, 35, 17, 19, 32};

        TreeNode root = new TreeNode(nk[0]);

        for (int i = 1; i < nk.length; i++) {
            insert(root, nk[i]);
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);

        System.out.println(" ");
        int  diameter = diameter(root);
        System.out.println("Diameter - number of nodes on the longest path between two leaves in the tree is: " + diameter);

    }
}
