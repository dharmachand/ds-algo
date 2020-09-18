package datastructures.linkedlists;

public class SwapPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
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
         int[] nums = {1, 2, 3, 4, 5, 6};

        ListNode head = populateList(nums);
        traverseList(head);

        traverseList(swapPairs(head));

        head = populateList(nums);
        traverseList(swapPairsRecursive(head));
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

    public static ListNode swapPairs(ListNode head) {
        // If linked list is empty or there is only one node in list
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize previous and current pointers
        ListNode prev = head;
        ListNode curr = head.next;

        head = curr; // Change head before proceeding

        // Traverse the list
        while (true) {
            ListNode next = curr.next;
            curr.next = prev; // Change next of current as previous node

            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // Change next of previous to next next
            prev.next = next.next;

            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return head;
    }

    public static ListNode swapPairsRecursive(ListNode head) {
        // Base Case: The list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Store head of list after two nodes
        ListNode remaining = head.next.next;

        // Change head
        ListNode newHead = head.next;

        // Change next of second node
        head.next.next = head;

        // Recur for remaining list and change next of head
        head.next = swapPairsRecursive(remaining);

        // Return new head of modified list
        return newHead;
    }
}
