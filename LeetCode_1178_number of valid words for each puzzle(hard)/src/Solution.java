import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findNumOfValidWords(new String[]{"aaaa"}, new String[]{"abcdefg"});
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask |= (1 << (c - 'a'));
            }
            //给定条件：puzzles[i].length == 7
            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> rst = new ArrayList<>();

        for (String puzzle : puzzles) {
            int total = 0;
            for (int i = 0; i < (1 << puzzle.length() - 1); i++) {
                int mask = 0;
                mask |= (1 << puzzle.charAt(0) - 'a');
                for (int j = 0; j < puzzle.length() - 1; j++) {
                    //当前这个子集(编码索引号)
                    if ((i & (1 << j)) != 0) {
                        //元素从右到左编码
                        mask |= (1 << puzzle.charAt(puzzle.length() - 1 - j) - 'a');
                    }
                }
                if (map.containsKey(mask)) {
                    total += map.get(mask);
                }
            }
            rst.add(total);
        }
        return rst;
    }
}

