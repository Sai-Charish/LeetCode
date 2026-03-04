class Solution:
    def romanToInt(self, s: str) -> int:
        result = 0
        for i in range(len(s)):
            if(s[i] == 'I'):
                result = result + 1


            elif(s[i] == 'V'):    
                result = result + 5
                if(s[i-1] == 'I' and i !=0):
                    result -= 2



            elif(s[i] == 'X'):
                result = result + 10
                if(s[i-1] == 'I' and i !=0):
                    result -= 2



            elif(s[i] == 'L'):
                result = result + 50
                if(s[i-1] == 'I' and i !=0):
                    result -= 2
                if(s[i-1] == 'X' and i !=0):
                    result -= 20



            elif(s[i] == 'C'):
                result = result + 100
                if(s[i-1] == 'I' and i !=0):
                    result -= 2
                if(s[i-1] == 'X' and i !=0):
                    result -= 20

            elif(s[i] == 'D'):
                result = result + 500
                if(s[i-1] == 'I' and i !=0):
                    result -= 2
                if(s[i-1] == 'X' and i !=0):
                    result -= 20
                if(s[i-1] == 'C' and i !=0):
                    result -= 200



            elif(s[i] == 'M'):
                result = result + 1000
                if(s[i-1] == 'I'and i !=0):
                    result -= 2
                if(s[i-1] == 'X'and i !=0):
                    result -= 20
                if(s[i-1] == 'C'and i !=0):
                    result -= 200

            
        return result
