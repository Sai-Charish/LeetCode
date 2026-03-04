class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        result = 0
        i = 0
        rev = s[::-1]
        print(rev)
        for _ in rev:
            if( _ == ' '):
                i += 1
            else:
                break

        print(i)
        while rev[i] != ' ':
            result += 1
            
            if(i+1 == len(rev)):
                return result

            else:
                i += 1
        
        return result

