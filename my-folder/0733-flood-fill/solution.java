class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        int n = image.length;
        int m = image[0].length;
        Queue <Coords> que = new LinkedList<>();
        int change = image[sr][sc];
        que.add(new Coords(sr,sc));
        image[sr][sc] = color;
        while(!que.isEmpty()){
            int size = que.size();
            for(int ind = 0;ind<size;ind+=1){
                Coords temp = que.poll();
                int i = temp.i;
                int j = temp.j;

                if(i-1 >= 0 && image[i-1][j] == change){
                    image[i-1][j] = color;
                    que.add(new Coords(i-1,j));
                }

                if(j-1 >= 0 && image[i][j-1] == change){
                    image[i][j-1] = color;
                    que.add(new Coords(i,j-1));
                }

                if(i+1 < n && image[i+1][j] == change){
                    image[i+1][j] = color;
                    que.add(new Coords(i+1,j));
                }

                if(j+1 < m && image[i][j+1] == change){
                    image[i][j+1] = color;
                    que.add(new Coords(i,j+1));
                }

            }
        }
        return image;
    }
}

class Coords {
    int i;
    int j;
    // int col;
    public Coords (int i,int j) {
        this.i = i;
        this.j = j;
    }
}
