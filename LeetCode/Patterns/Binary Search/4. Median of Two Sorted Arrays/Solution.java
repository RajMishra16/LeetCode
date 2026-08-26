class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int count=-1;
        int n=nums1.length;
        int m=nums2.length;
        int len=(n+m);
        
        double x=0;
        double y=0;
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(nums1[i]<nums2[j]){
                count++;
                if(count==(len-1)/2){
                    x=nums1[i];
                }
                else if(count==(len/2)){
                    y=nums1[i];
                }
                i++;
            }
            else {
                count++;
                if(count==(len-1)/2){
                    x=nums2[j];
                }
                else if(count==(len/2)){
                    y=nums2[j];
                }
             j++;
            }
        }
        while(i<n){
            count++;
            if(count==(len-1)/2){
                x=nums1[i];
            }
            else if(count==len/2){
                y=nums1[i];
            }
            i++;
        }

         while(j<m){
            count++;
            if(count==(len-1)/2){
                x=nums2[j];
            }
            else if(count==len/2){
                y=nums2[j];
            }
            j++;
        }
        if(len%2==1) return x;
        return (x+y)/2;


    }
}