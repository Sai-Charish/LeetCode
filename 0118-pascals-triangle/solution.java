class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i+=1){
            res.add(rowgenrater(i));
        }
        return res;
    }

    public List<Integer> rowgenrater(int n){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int num = 1;
        for(int i=1;i<=n;i+=1){
            num = num * (n-i+1);
            num = num/i;
            res.add(num);
        }
        
        return res;
    }
}
