public class Solution {
    public int longestOnes(int[] A, int K) {
        int max=0;
        int left=0,right=0;
        int cur0=0;
        while(right<A.length){
            if(A[right]==0){
                cur0++;
            }
            while(cur0>K){
                if(A[left]==0){
                    cur0--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}