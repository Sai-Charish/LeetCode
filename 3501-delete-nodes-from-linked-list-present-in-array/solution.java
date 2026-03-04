import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next; // remove node
            } else {
                curr = curr.next; // move forward
            }
        }

        return dummy.next;
    }
}
