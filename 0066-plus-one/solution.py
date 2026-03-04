class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if(digits[-1] < 9):
            digits[-1] += 1
            return digits
        else:
            num = int(''.join(map(str,digits))) + 1
            return [int(i) for i in str(num)]
