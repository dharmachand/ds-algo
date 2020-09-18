package datastructures.linkedlists;

public class Reverse {
    /**
     * Given a linked list, reverse the list.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     */

    /**
     * Definition for singly-linked list.
     */
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
         int[] nums = {1, 2, 3, 4, 5};

        ListNode head = populateList(nums);
        traverseList(head);

        traverseList(reverse(head));

        head = populateList(nums);
        traverseList(reverseRecursive(head));
    }

    private static ListNode populateList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode curr, prev = head;
        for (int i = 1; i < nums.length; i++) {
            curr = new ListNode(nums[i]);
            prev.next = curr;
            prev = curr;
        }
        return head;
    }

    private static void traverseList(ListNode head) {
         while (head != null) {
             System.out.print(head.val + " ");
             head = head.next;
         }
         System.out.println("");
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
