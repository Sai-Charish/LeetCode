class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =  new ArrayList<>();

        int col = matrix[0].length-1;
        int rows = matrix.length-1;

        int top = 0;
        int bottom = rows;
        int left = 0;
        int right = col;

        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i+=1)
            {
                res.add(matrix[top][i]);
            }
            top+=1;


            for(int i=top;i<=bottom;i+=1)
            {
                res.add(matrix[i][right]);
            }
            right-=1;

            if(top<=bottom)
            {
                for(int i=right;i>=left;i-=1)
                {
                    res.add(matrix[bottom][i]);
                }
                bottom-=1;
            }

            if(left<=right)
            {  
                for(int i=bottom;i>=top;i-=1)
                {
                    res.add(matrix[i][left]);
                }
                left+=1;
            }
        }

        

        return res;

    }
}
