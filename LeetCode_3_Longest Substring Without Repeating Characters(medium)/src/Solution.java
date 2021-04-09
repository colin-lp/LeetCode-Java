import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    Set<Character> set = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int rst = 0;
        while (right < s.length()) {
            if(left!=0){
                set.remove(s.charAt(left-1));
            }
            while(right<s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            left++;
            rst=Math.max(rst,right-left+1);
        }
        return rst;
    }
}
