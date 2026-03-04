class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int [] res = new int [n-k+1];

        for(int i=0;i<res.length;i+=1){
            int j = i+k-1;
            res[i] = calculate(nums,i,j,x);
        }

        return res;
    }

    public int calculate(int [] nums, int start,int end,int x){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int max = 0;
        for(int i=start;i<=end;i+=1){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            max = Math.max(max,freq.get(nums[i]));
        }

        ArrayList<ArrayList<Integer>> Bucket = new ArrayList<>();

        for(int i=0;i<=max;i+=1){
            Bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> pair : freq.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();

            Bucket.get(value).add(key);
        }

        for(int i=0;i<=max;i+=1){
            Collections.sort(Bucket.get(i));
        }

        int ans = 0;
        for(int i=max;i>0;i-=1) {
            for(int j=Bucket.get(i).size()-1 ; j>=0;j-=1){
                int value = Bucket.get(i).get(j);
                if(x > 0){
                    ans = ans + (value * i);
                    x-=1;
                }
            }
        }
        return ans;

    }
}
