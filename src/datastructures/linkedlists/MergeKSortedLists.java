package datastructures.linkedlists;

public class MergeKSortedLists {
    /**
     You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     Merge all the linked-lists into one sorted linked-list and return it.

     Solution:-
     Merge with Divide And Conquer
     Intuition & Algorithm

     This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

     Pair up \text{k}k lists and merge each pair.

     After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.

     Repeat this procedure until we get the final sorted linked list.

     Thus, we'll traverse almost N nodes per pairing and merging, and repeat this procedure about log2_k times.
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        if (len == 1) return lists[0];

        int incr = 1;
        while (incr < len) {
            for (int i = 0; i < len - incr; i += 2 * incr) {
                lists[i] = mergeTwoLists(lists[i], lists[i + incr]);
            }
            incr *= 2;
        }
        return lists[0];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        int[][] numLists = {{1,4,5},{1,3,4},{2,6}};

        ListNode[] lists = new ListNode[numLists.length];
        for (int i = 0; i < numLists.length; i++) {
            lists[i] = populateList(numLists[i]);
        }

        traverseList(mergeKLists(lists));
    }
}
