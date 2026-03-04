class Solution:
    def isPalindrome(self, s: str) -> bool:
        sam = s.lower()
        result = []
        for i in sam:
            if i.isalnum():
                result.append(i)
        
        output ="".join(result)
        print(output)
        return output == output[::-1]
