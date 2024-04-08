class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        # Sort the list of strings to easily find the common prefix
        strs.sort()
        print(strs)
        # Compare the first and last strings, since they would be the lexicographically smallest and largest
        first = strs[0]
        last = strs[-1]
        
        # Find the common prefix between the first and last strings
        prefix = ""
        for i in range(min(len(first), len(last))):
            if first[i] == last[i]:
                prefix += first[i]
            else:
                break
        
        return prefix
