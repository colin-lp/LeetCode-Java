import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("un");
        list.add("iq");
        list.add("ue");
        int rst = s.maxLength(list);
        System.out.println(rst);
    }

    int max = 0;

    public int maxLength(List<String> arr) {
        int[] masks = new int[arr.size()];
        int i = 0;
        for (String s : arr) {
            int checkResult = check(s);
            if (checkResult != 0) {
                masks[i++] = checkResult;
            }
        }
        dfs(masks, 0, 0);
        return max;
    }

    private void dfs(int[] masks, int index, int value) {
        if (masks.length == index) {
            //官方解法计算1的位数 Integer.bitCount()
            max = Math.max(Integer.bitCount(value), max);
            return;
        }
        //官方解法回溯 利用位运算计算和判断
        if (masks[index] != 0 && (masks[index] & value) == 0) {
            dfs(masks, index + 1, value | masks[index]);
        }
        dfs(masks, index + 1, value);
    }

    private int check(String str) {
        int template = 0;
        for (int i = 0; i < str.length(); i++) {
            int diff = str.charAt(i) - 'a';
            if ((template & (1 << diff)) == 0) {
                template = template | (1 << diff);
            } else {
                return 0;
            }
        }
        return template;
    }
}
