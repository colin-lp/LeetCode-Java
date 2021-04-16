public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int rst=s.rob(new int[]{2,3,2});
        System.out.println(rst);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        //first~last-1
        int[] dp =new int[n];
        dp[0]=nums[0];
        dp[1]= Math.max(nums[1], nums[0]);
        int i=0;
        for(i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int maxLeft=dp[nums.length-2];
        //second~last
        dp[1]=nums[1];
        dp[2]= Math.max(nums[1], nums[2]);
        for(i=3;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(maxLeft,dp[n-1]);
    }
}
