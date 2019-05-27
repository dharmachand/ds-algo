package datastructures.trees;

import java.util.*;

public class TreeSerialization {
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

    public static String serializeTree(TreeNode root) {
        if (root == null) return null;
        StringBuffer treeSb = new StringBuffer();

        preorder(root, treeSb);

        String treeStr = treeSb.toString();

        return treeStr.substring(0, treeStr.lastIndexOf(','));
    }

    public static TreeNode deSerializeTree(String str) {
        if (str == null) return null;

        LinkedList<Integer> treeNodes = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");

        while (tokenizer.hasMoreElements()) {
            treeNodes.add(Integer.parseInt(tokenizer.nextToken()));
        }

        return deSerializeTree(treeNodes);
    }

    public static void preorder(TreeNode root, StringBuffer treeSb) {
        if (root == null) return;

        treeSb.append(root.data)
                .append(",");

        if (root.left != null) {
            preorder(root.left, treeSb);
        } else {
            treeSb.append("-1")
                    .append(",");
        }

        if (root.right != null) {
            preorder(root.right, treeSb);
        } else {
            treeSb.append("-1")
                    .append(",");
        }
    }

    public static TreeNode deSerializeTree(LinkedList<Integer> treeNodes) {
        int val = treeNodes.poll();
        if (val == -1) return null;

        TreeNode root = new TreeNode(val, null, null);
        root.left = deSerializeTree(treeNodes);
        root.right = deSerializeTree(treeNodes);

        return root;
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
        String  serializedTree = serializeTree(root);
        System.out.println("Binary Tree after serialization: " + serializedTree);

        System.out.println(" ");
        TreeNode deSerializedTree = deSerializeTree(serializedTree);

        System.out.println("After deserialization, Tree elements inorder traversal: ");
        inorder(deSerializedTree);
    }
}
