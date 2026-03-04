class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m]; 

        for(int i=0;i<m;i+=1){
            if(grid[0][i] == 1 && !visited[0][i]){
                count += bfs(grid,visited,0,i);
            }
        }

        for(int i=1;i<n;i+=1){
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                count += bfs(grid,visited,i,m-1);
            }
        }

        for(int i=m-2;i>=0;i-=1){
            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                count += bfs(grid,visited,n-1,i);
            }
        }

        for(int i=n-2;i>=0;i-=1){
            if(grid[i][0] == 1 && !visited[i][0]){
                count += bfs(grid,visited,i,0);
            }
        }

        int total = 0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j] == 1){
                    total +=1;
                }
            }
        }

        return total - count;

    }

    public int bfs(int [][] grid,boolean [][] visited,int x,int y){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Coords> que = new LinkedList<>();
        que.add(new Coords(x,y));
        visited[x][y] = true;
        int count = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int ind=0;ind<size;ind+=1){
                Coords temp = que.poll();
                int i = temp.i;
                int j = temp.j;

                if(i-1>=0 && grid[i-1][j] == 1 && !visited[i-1][j]){
                    visited[i-1][j] = true;
                    que.add(new Coords(i-1,j));
                    count+=1;
                }

                if(j-1>=0 && grid[i][j-1] == 1 && !visited[i][j-1]){
                    visited[i][j-1] = true;
                    que.add(new Coords(i,j-1));
                    count+=1;
                }

                if(i+1 < n && grid[i+1][j] == 1 && !visited[i+1][j]){
                    visited[i+1][j] = true;
                    que.add(new Coords(i+1,j));
                    count+=1;
                }

                if(j+1 < m && grid[i][j+1] == 1 && !visited[i][j+1]){
                    visited[i][j+1] = true;
                    que.add(new Coords(i,j+1));
                    count+=1;
                }

            }
        }

        return count;

    }
    
    class Coords{
        int i;
        int j;
        public Coords(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    
}
