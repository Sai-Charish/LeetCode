class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = []
        freq_count = []
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if(nums[i] == nums[j]):
                    freq.append(nums[i])
                
        freq = list(set(freq))
        print(freq)

        if not freq:
            return len(nums)
        else:
            for i in range(len(freq)):
                freq_count.append(nums.count(freq[i]))

            print(freq_count)
            max_value = max(freq_count)
            print(max_value)
            result = 0
            for i in range(len(freq_count)):
                if(freq_count[i] == max_value):
                    result = result + freq_count[i]

            return result




        
