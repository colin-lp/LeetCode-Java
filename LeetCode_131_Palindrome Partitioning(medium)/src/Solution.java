import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.partition("aab"));
    }
    List<List<String>> rst=new ArrayList<>();
    List<String> temp=new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int len=s.length();
        dp=new boolean[len][len];
        char[] chars=s.toCharArray();
        for(int right=0;right<len;right++){
            for(int left=0;left<=right;left++){
                dp[left][right]=chars[left]==chars[right]&&(right-left<=2||dp[left+1][right-1]);
            }
        }
        dfs(0,len,s);
        return rst;
    }

    private void dfs(int cur,int len,String s){
        if(cur==len){
            rst.add(new ArrayList<>(temp));
            return;
        }
        for(int i=cur;i<len;i++){
            if(dp[cur][i]){
                temp.add(s.substring(cur,i+1));
                dfs(i+1,len,s);
                temp.remove(temp.size()-1);
            }
        }
    }
}
