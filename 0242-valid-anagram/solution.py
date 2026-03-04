class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        f = {}
        for i in s:
            if i in f:
                f[i] += 1
            else:
                f[i] = 1
            
        print(f)

        for j in t:
            if j not in f:
                return False
            elif f[j] == 1:
                del f[j]
            else:
                f[j] -= 1
                
        
        print(f)

        return not f


