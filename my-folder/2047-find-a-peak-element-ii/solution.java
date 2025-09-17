class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int row = mat.length-1;
        int col = mat[0].length-1;

        int low = 0;
        int high = col;

        while(low <= high)
        {
            int mid = (low + high)/2;
            int col_max = func(mat,mid);

            int current_element = mat[col_max][mid];
            int left = (mid==0) ? -1 : mat[col_max][mid-1];
            int right = (mid==col) ? -1 : mat[col_max][mid+1]; 

            if(current_element > left && current_element> right)
            {

                return new int [] {col_max,mid};
            }
            else if(current_element > left && current_element < right)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }

        }
        return new int[] {-1,-1};
        
    }

    public int func(int [][] mat,int mid)
    {
        int max = 0;

        for(int i=1 ;i<mat.length;i+=1)
        {
            if(mat[i][mid] > mat[max][mid])
            {
                max = i;
            }
        }
        return max;
    }
}
