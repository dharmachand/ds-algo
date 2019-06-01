package datastructures.trees;

import java.util.*;

public class Ancestors {
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

    public ArrayList<Integer> ancestorsList;

    public Ancestors() {
        this.ancestorsList = new ArrayList<>();
    }

    public boolean printAncestorsItr(TreeNode root, int nodeData) {
        if (root == null) return false;

        if (root.data == nodeData) return true;

        HashMap<TreeNode, TreeNode> childParentMap = new HashMap<>();
        childParentMap.put(root, null);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode curr, node = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();

            if (curr.left != null) {
                childParentMap.put(curr.left, curr);
                if (curr.left.data == nodeData) {
                    node = curr.left;
                    break;
                } else {
                    stack.push(curr.left);
                }
            }

            if (curr.right != null) {
                childParentMap.put(curr.right, curr);
                if (curr.right.data == nodeData) {
                    node = curr.right;
                    break;
                } else {
                    stack.push(curr.right);
                }
            }
        }

        while (node != null) {
            node = childParentMap.get(node);
            if (node != null) {
                ancestorsList.add(node.data);
            }
        }

        return ancestorsList.size() != 0;
    }

    public boolean printAncestors(TreeNode root, int nodeData) {
        if (root == null) return false;

        if (root.data == nodeData) return true;

        if (printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }

        return false;
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        System.out.println("Enter node to find: ");
        int nodeData = Integer.parseInt(scanner.nextLine());

        TreeNode root = new TreeNode(Integer.parseInt(nk[0]));

        for (int i = 1; i < nk.length; i++) {
            insert(root, Integer.parseInt(nk[i]));
        }

        System.out.println("Tree elements inorder traversal: ");
        inorder(root);
        System.out.println(" ");

        Ancestors ancestors =  new Ancestors();
        boolean found = ancestors.printAncestorsItr(root, nodeData);
        System.out.println("Ancestors (Iterative): " + found);
        System.out.println(ancestors.ancestorsList);

        ancestors =  new Ancestors();
        found = ancestors.printAncestors(root, nodeData);
        System.out.println("Ancestors (Recursive): " + found);
        System.out.println(ancestors.ancestorsList);

    }
}
