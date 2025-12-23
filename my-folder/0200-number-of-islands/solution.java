class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m];

        int count = 0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true;
                    bfs(grid,n,m,visited,i,j);
                    count+=1;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid,int n,int m,boolean[][] visited,int i,int j){
        Queue<Coords> que = new LinkedList<>();
        que.add(new Coords(i,j));
        while(!que.isEmpty()){
            Coords temp = que.poll();
            int x = temp.x;
            int y = temp.y;

            if(x+1<n && grid[x+1][y] == '1' && !visited[x+1][y]){
                visited[x+1][y] = true;
                que.add(new Coords(x+1,y));
            }

            if(x-1>=0 && grid[x-1][y] == '1' && !visited[x-1][y]){
                visited[x-1][y] = true;
                que.add(new Coords(x-1,y));
            }

            if(y+1<m && grid[x][y+1] == '1' && !visited[x][y+1]){
                visited[x][y+1] = true;
                que.add(new Coords(x,y+1));
            }

            if(y-1>=0 && grid[x][y-1] == '1' && !visited[x][y-1]){
                visited[x][y-1] = true;
                que.add(new Coords(x,y-1));
            }
        }
        return;
    }
}

class Coords{
    int x;
    int y;
    public Coords(int x,int y){
        this.x = x;
        this.y = y;
    }
}
