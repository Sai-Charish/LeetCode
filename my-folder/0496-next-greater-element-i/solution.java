class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] res = new int [n];

        for(int i=0;i<n;i+=1) {
            int index = -1;
            for(int j=0;j<m;j+=1) {
                if(nums1[i] != nums2[j]) {continue;}
                else{
                    while(j<m && nums2[j]<=nums1[i]){
                        j+=1;
                    }
                    if(j<m) {
                        res[i] = nums2[j];
                        index = j;
                        break;
                    }
                }
            }
            if(index == -1) {
                res[i] = -1;
            }
        }
        return res;
        
    }
}
