class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Coords> que = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j] == 2){
                    que.add(new Coords(i,j));
                }
                if(grid[i][j] == 1){
                    fresh+=1;
                }
            }
        }

        if(fresh == 0) return 0;

        int res = 0; 
        while(!que.isEmpty()){
            int size = que.size();
            for(int ind=0;ind<size;ind+=1){
                Coords temp = que.poll();
                int i = temp.i;
                int j = temp.j;
                
                if(i-1 >=0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    que.add(new Coords(i-1,j));
                }

                if(j+1 < m && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    que.add(new Coords(i,j+1));
                }

                if(i+1 < n && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    que.add(new Coords(i+1,j));
                }

                if(j-1 >= 0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    que.add(new Coords(i,j-1));
                }
            }
            res+=1;
        }

        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res-1;
    }

}

class Coords{
    int i;
    int j;
    public Coords(int i,int j) {
        this.i = i;
        this.j = j;
    }
}
