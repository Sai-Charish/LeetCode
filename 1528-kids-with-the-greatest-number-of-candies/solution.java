class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0;i<candies.length;i+=1){
            max = Math.max(max,candies[i]);
        }
        // System.out.println(max);

        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<candies.length;i+=1){
            if(candies[i]+extraCandies >= max){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}
