public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        boolean result=s.canPartition(new int[]{1,5,5,11});
        System.out.print(result);
    }
    public boolean canPartition(int[] nums) {
        if(nums.length<2) return false;
        int sum=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(nums[i],max);
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        if(max>target) return false;
        boolean dp[][]=new boolean[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            for(int j=0;j<target+1;j++){
                if(j>=num){
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-num];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}