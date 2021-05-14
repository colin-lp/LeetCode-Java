import java.util.Arrays;

public class Solution {
    //todo 1维dp
    public int numWays(int steps, int arrLen) {
        final int MOD=1000000007;
        //如果是arrlen而不是两参数值的min，则会超出内存限制(数组长度只需要到能到达最远的步数)
        int min=Math.min(arrLen,steps+1);
        int[][] dp=new int[steps+1][min];
        dp[0][0]=1;
        for(int i=1;i<steps+1;i++){
            for(int j=0;j<min;j++){
                //动作为不移动
                dp[i][j]=dp[i-1][j];
                if(j>0){
                    //这个位置也可以通过少一个步数的状态，不碰到边缘的情况下，向左走一步转移而来
                    dp[i][j]=(dp[i][j]+dp[i-1][j-1])%MOD;
                }
                if(j+1<min){
                    //这个位置也可以通过少一个步数的状态，不碰到边缘的情况下，向右走一步转移而来
                    dp[i][j]=(dp[i][j]+dp[i-1][j+1])%MOD;
                }
            }
        }
        //dp[步数][到达的位置]
        return dp[steps][0];
    }
}
