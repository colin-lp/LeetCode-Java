public class Solution {
    //official dp
    public int numDecodings(String s) {
        int[] dp =new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<=s.length();i++){
            //   _ cur 不为0则合法 可以加上累计量（所以dp数组长度为n+1）
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            //  _ _ cur 第一位不为0且 组合起来小于27则合法 可以加上累积量
            if(i>1 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<27){
                dp[i]+=dp[i-2];
            }
            // 如果都不合法 则默认为0
        }
        return dp[s.length()];
    }
}
