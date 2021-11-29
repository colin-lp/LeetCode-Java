import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeInvalidParentheses("()())()");
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> rst = new LinkedList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(s, 0, rst, left, right);
        return rst;
    }

    private void dfs(String s, int index, List<String> list, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                list.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.length() - i < left + right) {
                return;
            }
            if (left > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, list, left - 1, right);
            }
            if (right > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, list, left, right - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }
}