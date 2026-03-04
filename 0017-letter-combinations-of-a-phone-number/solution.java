class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap <Character,String> dict = new HashMap<>();

        dict.put('2',"abc");dict.put('3',"def");dict.put('4',"ghi");dict.put('5',"jkl");dict.put('6',"mno");dict.put('7',"pqrs");dict.put('8',"tuv");dict.put('9',"wxyz");

        String [] values = new String[digits.length()]; 
        for(int i=0;i<values.length;i+=1){
            values[i] = dict.get(digits.charAt(i));
        }

        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        helper(values,res,str,0);

        return res;
        
    }

    public void helper(String [] values,List<String> res ,StringBuilder str,int start){
        if(start == values.length){
            res.add(str.toString());
            return;
        }
        
        String word = values[start];
        for(int i=0;i<word.length();i+=1){
            str.append(word.charAt(i));
            helper(values,res,str,start+1);
            str.deleteCharAt(str.length()-1);
        }
    
        
    }    
}
