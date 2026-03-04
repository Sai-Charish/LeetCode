class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = list(needle)
        h = list(haystack)
        m = len(n)
        
        for i in range(len(h) - m + 1):
            if h[i:i+m] == n:
                return i
        
        return -1
