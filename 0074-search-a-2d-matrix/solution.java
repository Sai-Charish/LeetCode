class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right =  matrix[0].length-1;
        
        while(top <= bottom)
        {
            int mid = (top+bottom)/2;

            if(matrix[mid][left] > target)
            {
                bottom = mid-1;
            }
            else if(matrix[mid][right] < target)
            {
                top = mid+1;
            }
            else
            {
                while(left<=right)
                {
                    int mid2 = (left+right)/2;

                    if(matrix[mid][mid2] == target)
                    {
                        return true;
                    }
                    else if(matrix[mid][mid2] < target)
                    {
                        left = mid2+1;
                    }
                    else
                    {
                        right = mid2-1;
                    }
                }

                return false;

            }
        }
        return false;
        
    }
}
