class Solution {
    private static class Cell {
        int row, col, height;
        Cell(int r, int c, int h) {
            row = r; col = c; height = h;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // no water can be trapped

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        // 1. Push all boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int water = 0;

        // 2. Process heap
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] d : dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;

                visited[r][c] = true;
                water += Math.max(0, cell.height - heightMap[r][c]);

                // Effective boundary height
                pq.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
            }
        }

        return water;
    }
}

