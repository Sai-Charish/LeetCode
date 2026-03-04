import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length, n = heights[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;
        dfs(heights, visited, i + 1, j, heights[i][j]);
        dfs(heights, visited, i - 1, j, heights[i][j]);
        dfs(heights, visited, i, j + 1, heights[i][j]);
        dfs(heights, visited, i, j - 1, heights[i][j]);
    }
}

