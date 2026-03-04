class Solution {
    public int reversePairs(int[] nums) {

        int count = mergeSort(nums,0,nums.length-1);
        // for(int i=0;i<nums.length;i+=1) {
        //     System.out.print(nums[i] + " ");
        // }
        return count;
    }

    public int mergeSort(int [] nums,int low,int high) {
        int count = 0;
        if(low >= high) return 0;

        int mid = (low+high)/2;
        count += mergeSort(nums,low,mid);
        count += mergeSort(nums,mid+1,high);
        count += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);

        return count;
    }

    public int countPairs(int [] nums,int low,int mid,int high){
        int count = 0;
        int right = mid+1;

        for(int i=low;i<=mid;i+=1){
            while(right <= high && (long) nums[i] > 2L* nums[right]){
                right+=1;
            }
            count += right - mid-1;
        }
        return count;
    }

    public void merge (int [] nums,int low,int mid,int high) {
        int [] arr = new int [high+1 - low];

        int left=low;
        int right=mid+1;
        int i = 0;
        
        while(left <=mid && right <=high) {
            if(nums[left] <= nums[right]){
                arr[i] = nums[left];
                left+=1;
            }
            else {
                arr[i] = nums[right];
                right+=1;
            }
            i+=1;
        }

        while(left <= mid) {
            arr[i] = nums[left];
            i+=1;
            left+=1;
        }

        while(right <= high) {
            arr[i] = nums[right];
            i+=1;
            right+=1;
        }

        for(int j=0;j<arr.length;j+=1) {
            nums[low+j] = arr[j];
        }

    }
}
