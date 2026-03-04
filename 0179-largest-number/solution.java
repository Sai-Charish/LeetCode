class Solution {
    public String largestNumber(int[] nums) {
        String[] Values = new String [nums.length];
        for(int i=0;i<nums.length;i+=1){
            Values[i] = Integer.toString(nums[i]);
        }
        Values = sort(Values);

        StringBuilder Str = new StringBuilder();
        for(String i : Values) {
            Str.append(i);
        }
        System.out.println(Values[0]);
        if(Values[0].equals("0")) 
        {
            return "0"; 
        }
        return Str.toString();
    }
    public String[] sort(String[] Values){
        for(int i=0;i<Values.length;i+=1){
            for(int j=1;j<Values.length;j+=1){
                String a = Values[j-1];
                String b = Values[j];
                if((b+a).compareTo(a+b) > 0){
                    String temp = Values[j];
                    Values[j] = Values[j-1];
                    Values[j-1] = temp;
                }
            }
        }
        return Values;
    }
}
