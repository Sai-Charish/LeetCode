class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ref = []
        itr = 0

        while itr < len(nums):
            if nums[itr] not in ref:
                ref.append(nums[itr])
                itr += 1
            else:
                nums.pop(itr)  # Remove the element at index itr



            
        print(ref)        
