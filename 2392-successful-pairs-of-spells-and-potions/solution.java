class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int [] res = new int [spells.length];
        for(int i=0;i<n;i+=1){
            res[i] = helper(potions,spells[i],success);
        }
        return res;
    }

    public int helper(int [] potions,int multipiler,long success) {
        int low = 0;
        int high = potions.length-1;
        while(low<=high){
            int mid = low + (high-low) /2;
            long val = (long)potions[mid] * multipiler;
            if(val >= success) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return potions.length - low;
    }
}
