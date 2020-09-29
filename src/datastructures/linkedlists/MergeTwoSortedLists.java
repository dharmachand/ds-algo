package datastructures.linkedlists;

public class MergeTwoSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new sorted list.
     * The new list should be made by splicing together the nodes of the first two lists.
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
        int[] n1 = {1, 2, 4};
        int[] n2 = {1, 3, 4};

        ListNode l1 = populateList(n1);
        traverseList(l1);
        ListNode l2 = populateList(n2);
        traverseList(l2);

        traverseList(mergeTwoLists(l1, l2));

        //reset input lists
        l1 = populateList(n1);
        l2 = populateList(n2);

        traverseList(mergeTwoListsRecursive(l1, l2));
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l3Head = new ListNode(100);
        ListNode l3 = l3Head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (l1 != null) l3.next = l1;
        if (l2 != null) l3.next = l2;

        return l3Head.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
