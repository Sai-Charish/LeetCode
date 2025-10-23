class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        int n= intervals.length;
        List<int[]> Store = new ArrayList<>();
        
        Store.add(intervals[0]);    
        int size = 1  ;
        for(int i=1;i<n;i+=1){
            int [] last = Store.get(size-1);

            if(last[1] < intervals[i][0]){
                Store.add(intervals[i]);
                size+=1;
            }
            else {
                last[1] = Math.max(last[1],intervals[i][1]);
            }
        }
        
        int [][] res = new int [size][2];

        for(int i=0;i<res.length;i+=1){
            res[i] = Store.get(i);
        }

        return res;
    }
}
