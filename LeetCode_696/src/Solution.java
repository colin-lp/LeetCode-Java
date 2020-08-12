import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.countBinarySubstrings("10101000101010101010101010101010");
        int or= s.countBinarySubstringsOfficial("10101000101010101010101010101010");
        System.out.println(r);
        System.out.println(or);
    }

    public int countBinarySubstrings(String s) {
        LinkedList<Character> l1 = new LinkedList<Character>();
        LinkedList<Character> l2 = new LinkedList<Character>();
        int result = 0;
        int pre = -1;//++@小名的魔法少爷 标记
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '0') {
                //++@小名的魔法少爷 如果这次为0前面为1，则不存在连续了，只计算一次后清空0。
                if (pre == 1) l1 = new LinkedList<Character>();
                if (l2.size() == 0) {
                } else {
                    l2.pop();
                    result++;
                    pre = 0;
                }
                l1.push(c);
            } else if (c == '1') {
                //++@小名的魔法少爷 如果这次为1前面为0，则不存在连续了，只计算一次后清空1。
                if (pre == 0) l2 = new LinkedList<Character>();
                if (l1.size() == 0) {
                } else {
                    l1.pop();
                    result++;
                    pre = 1;
                }
                l2.push(c);
            }
        }
        return result;
    }

    public int countBinarySubstringsOfficial(String s) {
        int i = 0, n = s.length(), last = 0, ans = 0;
        while (i < n) {
            char c = s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                count++;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}