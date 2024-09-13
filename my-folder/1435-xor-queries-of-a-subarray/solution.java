class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int [] result = new int [n];

        for(int i=0;i<n;i+=1)
        {
            int res = 0;
            
            int left = queries[i][0];
            int right = queries[i][1];

            for(int j = left;j <= right;j+=1)
            {
                res = res ^ arr[j]; 
            }

            result[i] = res;

        }

        return result;
    }
}

//  2 - 3
//  1 - 3
//  0 - 0
//  0 - 3

// 2 xor 10 == 10 1010  1000 == 8
// 8 xor 2 xor 10 == 1000 10 == 1010 1010 == 0000 = 0
// 4 xor 0  100 000 == 100 = 4
// 4 xor 8 xor 2 xor 10 == 100 1000 == 1100 10 == 1110 1010 == 0100 == 4
