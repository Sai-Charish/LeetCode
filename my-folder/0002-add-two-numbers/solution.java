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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dn = new ListNode(-1);
        ListNode curr = dn;
        int carry = 0;

        while(l1!=null || l2!=null)
        {
            int sum = carry;
            if(l1 != null)
            {
                sum += l1.val;
            }
            if(l2 != null)
            {
                sum += l2.val;
            }


            ListNode n = new ListNode(sum%10);
            curr.next = n;
            curr = curr.next;

            carry = sum/10;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0)
        {
            ListNode n = new ListNode(carry);
            curr.next = n;
            curr = curr.next;
        }
        return dn.next;
    }
}
