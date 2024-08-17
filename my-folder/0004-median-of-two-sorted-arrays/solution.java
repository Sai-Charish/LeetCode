class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res=0;

        int [] arr = new int [nums1.length+nums2.length];
        int n = arr.length;
    

        for(int i=0;i<nums1.length;i+=1)
        {
            arr[i]=nums1[i];
        }

        for(int i=0;i<nums2.length;i+=1)
        {
            arr[i+nums1.length]=nums2[i];
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i+=1)
        {
            System.out.println(arr[i]);
        }

        int m;
        m = n/2;
        
        if(n%2==0)
        {
            double a = arr[m-1];
            double b = arr[m];
            res = (a+b)/2;
        }
        else
        {
            res = arr[m];
        }
        
        return res;
    }
}
