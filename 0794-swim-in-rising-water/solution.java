import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int result = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0], i = curr[1], j = curr[2];
            result = Math.max(result, height);
            
            if (i == n - 1 && j == n - 1) return result;
            if (visited[i][j]) continue;
            visited[i][j] = true;
            
            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    pq.offer(new int[]{grid[x][y], x, y});
                }
            }
        }
        return result;
    }
}

