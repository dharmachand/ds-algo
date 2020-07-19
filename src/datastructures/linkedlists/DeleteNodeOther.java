package datastructures.linkedlists;

public class DeleteNodeOther {
    public static class ListNode {
        int val;
        DeleteNodeOther.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, DeleteNodeOther.ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        }

        return head;
    }

    public static ListNode removeElementsOther(ListNode head, int val) {
        ListNode curr = head, prev = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else  prev = curr;
            curr = curr.next;
        }

        if (head != null && head.val == val) head = head.next;

        return head;
    }

    public static void main(String[] args) {
        int[] list = {1,2,6,3,4,5,6};
        int delete = 6;

        ListNode head = null, node = null;
        for (int i = 0; i < list.length; i++) {
            if (node == null) {
                node = new ListNode(list[i]);
                head = node;
            } else {
                node.next = new ListNode(list[i]);
                node = node.next;
            }
        }

        head = removeElements(head, delete);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
