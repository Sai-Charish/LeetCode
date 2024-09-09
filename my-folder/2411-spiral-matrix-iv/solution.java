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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] result = new int [m][n];
        ListNode temp = head;

        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;

        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right;i+=1)
            {
                if(temp == null)
                {
                    result[top][i] = -1;
                }
                else
                {
                    result[top][i] = temp.val;
                    temp = temp.next;
                }

            }

            top++;

            for(int i = top ; i <= bottom ;i+=1)
            {
                if(temp == null)
                {
                    result[i][right] = -1;
                }
                else
                {
                    result[i][right] = temp.val;
                    temp = temp.next;
                }
                
            }

            right --;
            
            if( top <= bottom)
            {
                for(int i = right; i >= left ;i-=1)
                {
                    if(temp == null)
                    {
                        result[bottom][i] = -1;
                    }
                    else
                    {
                        result[bottom][i] = temp.val;
                        temp = temp.next;
                    }
                        
                }
                
                bottom--;
            }

            if(left <= right)
            {
                for(int i = bottom; i >=top ;i-=1)
                {
                    if(temp == null)
                    {
                        result[i][left] = -1;
                    }
                    else
                    {
                        result[i][left] = temp.val;
                        temp = temp.next;
                    }
                    
                }
                
                left++;
            }
        }
        return result;
    }
}
