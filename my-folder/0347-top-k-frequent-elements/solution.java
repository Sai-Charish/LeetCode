class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int size = 0;
        for(int i=0;i<nums.length;i+=1){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            size = Math.max(freq.get(nums[i]),size);
        }

        ArrayList<ArrayList<Integer>> Bucket = new ArrayList<>();

        for(int i=0;i<=size;i+=1){
            Bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> pair : freq.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            Bucket.get(value).add(key);
        }

        int [] res = new int [k];

        for(int i=Bucket.size()-1;i>=0;i-=1){
            if(k==0) break;
            for(int j = Bucket.get(i).size()-1;j>=0;j-=1){
                if(k>0){
                    res[k-1] = Bucket.get(i).get(j);
                    k-=1; 
                }
            }
        }

        return res;

    }
}
