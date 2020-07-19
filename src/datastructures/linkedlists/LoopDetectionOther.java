package datastructures.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class LoopDetectionOther {
    public static class ListNode {
        int val;
        LoopDetectionOther.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, LoopDetectionOther.ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean hasCycleWithExtraDs(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (visitedNodes.contains(curr)) return true;
            else {
               visitedNodes.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {3,2,0,-4};
        LoopDetectionOther.ListNode head = null, node = null;
        for (int i = 0; i < input.length; i++) {
            if (node == null) {
                node = new LoopDetectionOther.ListNode(input[i]);
                head = node;
            } else {
                node.next = new LoopDetectionOther.ListNode(input[i]);
                node = node.next;
            }
        }
        node.next = head.next;

        System.out.println("hasCycle (with extra storage): " + hasCycleWithExtraDs(head));
        System.out.println("hasCycle: " + hasCycle(head));
    }
}
