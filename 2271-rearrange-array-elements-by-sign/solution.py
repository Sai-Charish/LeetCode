class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos=[]
        neg=[]
        for i in range(len(nums)):
            if(nums[i]<0):
                neg.append(nums[i])
            else:
                pos.append(nums[i])
        
        result=[]
        
        for i in  range(len(pos)):
            result.append(pos[i])
            result.append(neg[i])
        
        return result


