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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
        {
            return null;
        }    

        ListNode dn = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode curr1 = null;
        ListNode temp2 = list2;
        ListNode curr2 = null;
        ListNode curr3 = dn;


        while(temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                curr1 = temp1;
                temp1 = temp1.next;
                curr3.next = curr1;
                curr3 = curr3.next;
                curr1.next = null;
            }
            else
            {
                curr2 = temp2;
                temp2 = temp2.next;
                curr3.next = curr2;
                curr3 = curr3.next;
                curr2.next = null;
            }
        }

        if(temp1!= null)
        {
            curr3.next = temp1;   
        }

        if(temp2!= null)
        {
            curr3.next = temp2;   
        }

        return dn.next;
    }
}
