class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if not order:
            return s
            
        result = ""
        test_str = s
        for i in order :
            for j in s:
                if(j == i):
                    result = result + j
                    test_str = test_str.replace(i,'')

        print(test_str)

        result = result + test_str
        
        return result

        
