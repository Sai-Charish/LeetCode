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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        {
            return true;
        }
        

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null)
        {
            slow = slow.next;
        }

        ListNode i =  reverse(slow);
        slow = head;

        while(slow.next!=null && i != null)
        {
            if(slow.val != i.val)
            {
                return false;
            }
            slow = slow.next;
            i = i.next;
        }


        return true;
    }

    public ListNode reverse(ListNode head)
    {
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
