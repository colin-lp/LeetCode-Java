public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (j = i; (j - i) < needle.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
            }
            if (j - i == needle.length()) return i;
        }
        return -1;
    }
}