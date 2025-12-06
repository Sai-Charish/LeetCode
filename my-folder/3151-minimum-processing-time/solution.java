class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks,(a,b) -> Integer.compare(b,a));
        int n = processorTime.size();
        
        int max = 0;

        for(int i=0;i<n;i+=1){
            int sum = processorTime.get(i) + tasks.get(i*4);
            max = Math.max(max,sum);
        }
        return max;

    }
}
