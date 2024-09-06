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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap <Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i+=1)
        {
            map.put(nums[i],1);
        }

        System.out.println(map);

        ListNode temp = head;
        ListNode prev = temp;
        ListNode current;

        while(temp  != null)
        {
            if(temp == head && map.containsKey(temp.val))
            {
                head = head.next;
                
            }
            else if(temp.next !=null && map.containsKey(temp.val))
            {
                current = temp;
                temp = temp.next;
                prev.next = temp;
                current.next = null;
                temp = prev; 
            }
            else if(temp.next == null && map.containsKey(temp.val))
            {
                prev.next = null;
            }
            prev = temp;
            temp = temp.next;
            
        }



        return head;
    }
}
