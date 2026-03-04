class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return helper(grid,grid.length,0,0,0);
    }

    public boolean helper(int [][] grid,int n,int i,int j,int exval) {
        if(i<0 || j<0 || i>=n || j>=n || exval != grid[i][j]) return false;

        if(exval == (n*n-1)) return true;

        boolean ans1 = helper(grid,n,i-2,j+1,exval+1);
        boolean ans2 = helper(grid,n,i-1,j+2,exval+1);
        boolean ans3 = helper(grid,n,i+1,j+2,exval+1);
        boolean ans4 = helper(grid,n,i+2,j+1,exval+1);
        boolean ans5 = helper(grid,n,i-2,j-1,exval+1);
        boolean ans6 = helper(grid,n,i-1,j-2,exval+1);
        boolean ans7 = helper(grid,n,i+1,j-2,exval+1);
        boolean ans8 = helper(grid,n,i+2,j-1,exval+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}
