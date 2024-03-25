class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        output = []
        i=0
        j=1
        nums.sort()
        print(nums)
        while j < len(nums):
            if(nums[i] == nums[j]):
                output.append(nums[i])
            i+=1
            j+=1

        return output
