class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> store = new ArrayList<>();

        store.add(intervals[0]);
        int size = 1;

        for(int i=1;i<intervals.length;i+=1){
            int [] last = store.get(size-1);
            if(last[1] < intervals[i][0]){
                store.add(intervals[i]);
                size+=1;;
            }
            else {
                last[1] = Math.max(last[1],intervals[i][1]);
            }
        }


        int [][] res = new int [size][2];

        for(int i=0;i<size;i+=1){
            res[i] = store.get(i);
        }

        return res;
    }
}
