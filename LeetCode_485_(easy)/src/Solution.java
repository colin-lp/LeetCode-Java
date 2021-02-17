public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cons=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cons++;
            }else{
                if(cons>max){
                    max=cons;
                }
                cons=0;
            }
        }
        if(cons!=0) return cons>max?cons:max;
        return max;
    }
}