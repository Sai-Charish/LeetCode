class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        
        while(i < n && start > intervals[i][1]){
            ans.add(intervals[i]);
            i+=1;
        }

        while(i < n && end >= intervals[i][0]) {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i+=1;
        }

        ans.add(new int[] {start,end});

        while(i < n ) {
            ans.add(intervals[i]);
            i+=1;
        }

        int size = ans.size();
        int [][] res = new int [size][2];

        for(int ind=0;ind<size;ind+=1){
            res[ind] = ans.get(ind);
        }

        return res;

    }
}
