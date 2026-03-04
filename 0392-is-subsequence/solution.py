class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        sl = list(s)
        tl = list(t)

        n = 0
        m = 0
        while sl  and tl :
            if(sl[n]==tl[m]):
                sl.pop(n)
                tl.pop(m)
            else:
                tl.pop(m)
        
        print(sl)
        print(tl)

        return not sl

        
