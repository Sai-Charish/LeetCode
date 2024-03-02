/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int i,j,temp;
    *returnSize = numsSize;
    int* output = (int*)malloc(numsSize*sizeof(int)); 
    for(i=0;i<numsSize;i++)
    {
        output[i]= nums[i] * nums[i];
    }

    for(i = 0 ; i<numsSize; i++)
    {
        for(j=i+1; j<numsSize;j++)
        {
            if(output[i]>output[j])
            {
                temp = output[i];
                output[i] = output[j];
                output[j] = temp;
            }
        }
    }
    return output;
}
