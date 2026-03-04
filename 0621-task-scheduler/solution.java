class Solution {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int [26];
        for(int i=0;i<tasks.length;i+=1){
            arr[tasks[i] - 'A'] +=1;
        }

        Queue<Pair> que = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i=0;i<26;i+=1){
            if(arr[i] !=0 ){
                pq.add(arr[i]);
            }
        }

        int time = 0;

        while(!pq.isEmpty() || !que.isEmpty()){
            
            while(!que.isEmpty() && que.peek().ti == time){
                pq.add(que.poll().cnt);
            }

            int temp;
            if(!pq.isEmpty()){
                temp = pq.poll();
                if(temp-1 > 0){
                    que.add(new Pair(temp-1,time+n+1));
                }
            }
            
            time +=1;
        }

        return time;
    }
}

class Pair{
    int cnt;
    int ti;
    public Pair(int cnt,int ti){
        this.cnt = cnt;
        this.ti = ti;
    }
}
