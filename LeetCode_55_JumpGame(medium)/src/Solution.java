class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int max=0;
        boolean rst=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(max+i>=nums.length-1){
                rst=true;
                break;
            }
            if(nums[i]==0 && max==0){
                break;
            }
            max--;
        }
        return rst;
    }
}