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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode left = head;
        ListNode middle = head;
        ListNode right = head;

        while(right.next!=null && right.next.next!=null)
        {
            middle = middle.next;
            right = right.next.next;
        }
        
        right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left,right);
        
    }
    public ListNode merge(ListNode list1,ListNode list2)
    {
        if(list1==null && list2==null)
        {
            return null;
        }    

        ListNode dn = new ListNode(-1);
        ListNode curr3 = dn;


        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                curr3.next = list1;
                curr3 = list1;
                list1 = list1.next;
            }
            else
            {
                curr3.next = list2;
                curr3 = list2;
                list2 = list2.next;
            }
        }

        if(list1!= null)
        {
            curr3.next = list1;   
        }

        if(list2!= null)
        {
            curr3.next = list2;   
        }

        return dn.next;
    }
}
