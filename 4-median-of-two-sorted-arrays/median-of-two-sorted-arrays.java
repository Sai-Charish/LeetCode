class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = (n1+n2+1)/2;
        

        while(low <= high)
        {
            int mid = (low+high)/2;
            int l1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid-1];
            int r1 =  (mid == n1)? Integer.MAX_VALUE : nums1[mid];
            int l2 = (total-mid == 0) ? Integer.MIN_VALUE : nums2[total-mid-1];
            int r2 = (total-mid == n2) ? Integer.MAX_VALUE : nums2[total-mid];

            if(l1 <= r2 && l2 <= r1)
            {
                double ans = 0;
                if((n1+n2)%2 == 0)
                {
                    ans = Math.max(l1,l2) + Math.min(r1,r2);
                    ans = ans/2;
                }
                else
                {
                    ans = Math.max(l1,l2);
                }
                
                return ans;
            }
            else if(l1 > r2 )
            {
                high = mid+-1;                
            }
            else
            {
                low = mid+1;
            }

        }

        return 0;
    }
}