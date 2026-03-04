# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        temp1 = l1
        temp2 = l2
        l3 = ListNode()
        current = l3

        sum1 = sum2 = 0
        digit1 = digit2 = 1 

        while l1 is not None:
            
            sum1 = sum1 + (l1.val*digit1)
            digit1 = digit1*10 
            l1=l1.next

        while l2 is not None:
            
            sum2 = sum2 + (l2.val*digit2)
            digit2 = digit2*10 
            l2=l2.next
            
        total = sum1 + sum2
        print(total,sum1,sum2)

        if total == 0:
            return ListNode(0)

        while total != 0:
            add_digit = total % 10
            total = total//10
            current.next = ListNode(add_digit)
            current = current.next

        return l3.next


        
