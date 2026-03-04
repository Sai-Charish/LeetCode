class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));

        int count = 1;
        int first = intervals[0][0];  
        int last = intervals[0][1];
        for(int i=1;i<intervals.length;i+=1){
            if(last <= intervals[i][0]){
                count+=1;
                last = intervals[i][1];
            }
        }

        return intervals.length - count;
        
    }
}
