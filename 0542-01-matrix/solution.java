class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Coords> que = new LinkedList<>();
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (mat[i][j] == 0) {
                    que.add(new Coords(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int ind = 0; ind < size; ind += 1) {
                Coords temp = que.poll();
                int i = temp.i;
                int j = temp.j;

                res[i][j] = level;

                if (i - 1 >= 0 && !visited[i-1][j]) {
                    visited[i-1][j] = true;
                    que.add(new Coords(i - 1, j));
                }

                if (j - 1 >= 0 && !visited[i][j-1]) {
                    visited[i][j-1] = true;
                    que.add(new Coords(i, j - 1));
                }

                if (i + 1 < n && !visited[i+1][j]) {
                    visited[i+1][j] = true;
                    que.add(new Coords(i + 1, j));
                }

                if (j + 1 < m && !visited[i][j+1]) {
                    visited[i][j+1] = true;
                    que.add(new Coords(i, j + 1));
                }
            }
            level += 1;
        }

        return res;
    }
}

class Coords {
    int i;
    int j;

    public Coords(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
