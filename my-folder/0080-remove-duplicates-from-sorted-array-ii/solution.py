class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return len(nums)
        
        # Initialize variables
        index = 2
        
        # Iterate through the array
        for i in range(2, len(nums)):
            # Check if the current element is not equal to the element two positions back
            if nums[i] != nums[index - 2]:
                nums[index] = nums[i]
                index += 1
        
        return index
