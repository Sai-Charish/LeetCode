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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = null;

        ListNode temp = head;
        while(temp != null)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null) break;

            ListNode newHead = kthNode.next;
            kthNode.next = null;
            ListNode rev = reverse(temp);

            if(dummyNode.next == null) 
            {
                dummyNode.next = rev;
            }
            else
            {
                prev.next = rev;
            } 
            prev = temp;
            temp = newHead;
        }
        
        if(temp!=null)
        {
            prev.next = temp;
        }
        return dummyNode.next;
    }

    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode next = null;
        ListNode prev = null;
        while(temp.next != null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        temp.next = prev;
        return temp;
    }

    public ListNode  findKthNode(ListNode temp, int k)
    {
        if(temp == null) return temp;
        while(temp != null && k>1){
            temp = temp.next; 
            k-=1;
        }
        return (temp == null) ? null : temp;
    }
}
