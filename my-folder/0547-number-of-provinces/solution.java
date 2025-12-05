class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] visited = new boolean [n];

        int count = 0;
        for(int i=0;i<n;i+=1){
            if(!visited[i]){
                count+=1;
                dfs(isConnected,n,visited,i);
            }
        }

        return count;
    }

    public void dfs (int [][] isConnected,int n,boolean [] Visited,int curr){
        Visited[curr] = true;

        for(int i=0;i<n;i+=1){
            if(!Visited[i] && isConnected[curr][i] == 1){
                dfs(isConnected,n,Visited,i);
            }
        }
    }
}
