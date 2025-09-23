/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return head;
        }

        ListNode temp1 = null;
        ListNode temp2 = head;
        ListNode temp3 = head.next;

        while(temp3 != null)
        {
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;
        }

        temp2.next = temp1;

        return temp2;

    }
}
