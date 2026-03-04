class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int j=0;j<row;j+=1)
        {
            for(int i=0;i<j;i+=1)
            {
                swap(matrix,i,j);
            }
        }
        
        for(int i=0;i<row;i+=1)
        {
            reverse(matrix[i]);
        }
        return;

    }

    public void reverse(int[] arr)
    {
        int i=0;
        int j=arr.length-1;

        while(i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i+=1;
            j-=1;
        }
    }
    public void swap(int[][] matrix, int i,int j)
    {
        int temp  = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;

        return;
    }
}
