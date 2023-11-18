import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> findRepeatedDnaSequences = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List<String> expected = new ArrayList<>();
        expected.add("AAAAACCCCC");
        expected.add("CCCCCAAAAA");
        if (findRepeatedDnaSequences.equals(expected)) {
            System.out.println(true);
        } else {
            System.out.println(false);
            System.out.println(findRepeatedDnaSequences.toString());
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> StringCountMap = new HashMap<>();
        Map<Character, Integer> sequence = new HashMap<>();
        sequence.put('A', 0b00);
        sequence.put('G', 0b01);
        sequence.put('C', 0b10);
        sequence.put('T', 0b11);
        List<String> result = new ArrayList<>();
        int temp = 0;
        int left = 0;
        int right = 0;
        for (; right < s.length(); right++) {
            // (xxx) & xxx
            temp = (temp << 2 | sequence.get(s.charAt(right))) & ((1 << 20) - 1);
            if ((right - left + 1) < 10) {
            } else {
                int count = StringCountMap.getOrDefault(temp, 0);
                count++;
                StringCountMap.put(temp, count);
                if (count == 2) {
                    result.add(s.substring(left, right + 1));
                }
                left++;
            }
        }
        return result;
    }
}