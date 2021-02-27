import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int max=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()<k){
                for(String sub:s.split(entry.getKey().toString())){
                    max=Math.max(max,longestSubstring(sub,k));
                }
                return max;
            }
        }
        return s.length();
    }
}
