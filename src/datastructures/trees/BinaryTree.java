package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    private Node root;

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            this.key = item;
            this.left = this.right = null;
        }
    }

    public BinaryTree(int key) {
        this.root = new Node(key);
    }

    public BinaryTree() {
        this.root = null;
    }

    //inorder traversal starting from given node
    public void inorder(Node currNode) {
        if (currNode == null) { return; }

        inorder(currNode.left);
        System.out.print(currNode.key + " ");
        inorder(currNode.right);
    }

    //inorder traversal starting from root
    public void inorder() {
        if (this.root == null) { return; }

        inorder(this.root);
    }

    //pre-order traversal starting from given node
    public void preorder(Node currNode) {
        if (currNode == null) { return; }

        System.out.print(currNode.key + " ");
        preorder(currNode.left);
        preorder(currNode.right);
    }

    //pre-order traversal starting from root
    public void preorder() {
        if (this.root == null) { return; }

        preorder(this.root);
    }

    //post-order traversal starting from given node
    public void postorder(Node currNode) {
        if (currNode == null) { return; }

        postorder(currNode.left);
        postorder(currNode.right);
        System.out.print(currNode.key + " ");
    }

    //post-order traversal starting from root
    public void postorder() {
        if (this.root == null) { return; }

        postorder(this.root);
    }

    //level-order traversal or Breadth First traversal starting from given node
    public void levelorder(Node currNode) {
        if (currNode == null) { return; }

        Queue<Node> queue = new LinkedList<>();
        queue.add(currNode);

        while (!queue.isEmpty()) {
            currNode = queue.peek();
            System.out.print(currNode.key + " ");
            queue.remove();

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
    }

    //level-order traversal or Breadth First traversal starting from root
    public void levelorder() {
        if (this.root == null) { return; }

        levelorder(this.root);
    }

    public void insert(Node currNode, int key) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(currNode);

        //Do Level Order traversal or Breadth First traversal and insert at empty place
        while (!queue.isEmpty()) {
            currNode = queue.peek();
            queue.remove();

            if (currNode.left == null) {
                currNode.left = new Node(key);
                break;
            } else {
                queue.add(currNode.left);
            }

            if (currNode.right == null) {
                currNode.right = new Node(key);
                break;
            } else {
                queue.add(currNode.right);
            }
        }
    }

    public void insert(int key) {
        if (this.root == null) {
            this.root = new Node(key);
        } else {
            insert(root, key);
        }
    }


    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < nk.length; i++) {
            binaryTree.insert(Integer.parseInt(nk[i]));
        }

        System.out.println("InOrder traversal of elements: ");
        binaryTree.inorder();
        System.out.println("");

        System.out.println("PreOrder traversal of elements: ");
        binaryTree.preorder();
        System.out.println("");

        System.out.println("PostOrder traversal of elements: ");
        binaryTree.postorder();
        System.out.println("");

        System.out.println("LevelOrder traversal of elements: ");
        binaryTree.levelorder();
        System.out.println("");

    }

}
