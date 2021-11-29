import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> rst = new LinkedList<>();
        Map<String, Integer> reverse = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reverse.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            if (len == 0) continue;
            int index;
            for (int j = 0; j < len; j++) {
                if (j != 0 && isValid(words[i], 0, j - 1)) {
                    String rev = words[i].substring(j, len);
                    index = reverse.getOrDefault(rev, -1);
                    if (index != -1 && index != i) {
                        rst.add(Arrays.asList(index, i));
                    }
                }
                if (isValid(words[i], j, len - 1)) {
                    String rev = words[i].substring(0, j);
                    index = reverse.getOrDefault(rev, -1);
                    if (index != -1 && index != i) {
                        rst.add(Arrays.asList(i, index));
                        if ("".equals(rev)) {
                            rst.add(Arrays.asList(index, i));
                        }
                    }
                }
            }
            index = reverse.getOrDefault(words[i], -1);
            if (index != -1 && index != i) {
                rst.add(Arrays.asList(index, i));
            }
        }

        return rst;
    }

    private boolean isValid(String str, int left, int right) {
        int mid = (right - left) / 2;

        for (int i = 0; i <= mid; i++) {
            if (str.charAt(left + i) != str.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }
}
