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
    public ListNode[] splitListToParts(ListNode head, int k) {

    ListNode[] result = new ListNode[k];

    ListNode temp = head;
    int count = 0;

    // Count the total number of nodes
    while (temp != null) {
        count += 1;
        temp = temp.next;
    }

    int current_length;
    int j = 0;
    ListNode prev = null;
    temp = head;

    while (j < k) {
        if(temp ==  null)
        {
            result[j] = temp;
        }
        else
        {
            result[j] = temp;
            current_length = (count/k) + ( j < count % k ? 1:0);

            for(int i=0 ; i < current_length;i+=1)
            {
                prev = temp;
                temp = temp.next;
            }

            if(prev != null)
            {
                prev.next = null;
            }
        }
        j+=1;
    }

    return result;
}

}
