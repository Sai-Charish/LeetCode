# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        
        temp1,temp2 = head , head
        
        while temp1 and temp1.next:
          temp2 = temp2.next
          temp1 = temp1.next.next
          if temp2 == temp1:
            return True

        return False
        
