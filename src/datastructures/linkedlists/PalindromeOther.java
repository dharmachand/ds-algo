package datastructures.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class PalindromeOther {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> palindList = new ArrayList<>();
        while (head != null) {
            palindList.add(head.val);
            head = head.next;
        }
        int i = 0, j = palindList.size() - 1;
        while (i < j) {
            if (!palindList.get(i).equals(palindList.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 1};

        ListNode head = null, node = null;
        for (int i = 0; i < input.length; i++) {
            if (node == null) {
                node = new ListNode(input[i]);
                head = node;
            } else {
                node.next = new ListNode(input[i]);
                node = node.next;
            }
        }

        System.out.println("isPalindrome: " + isPalindrome(head));
    }


}
