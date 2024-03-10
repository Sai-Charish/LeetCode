class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        n1 = set(nums1)
        n2 = set(nums2)

        for i in n1:
            if i in n2:
                result.append(i)

        return result
        
