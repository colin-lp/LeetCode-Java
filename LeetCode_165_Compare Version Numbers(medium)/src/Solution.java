public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.compareVersion("1.0.0", "1.0");
        System.out.println(r);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1arr;
        String[] v2arr;
        v1arr = version1.split("\\.");
        v2arr = version2.split("\\.");
        int max = Math.max(v1arr.length, v2arr.length);
        int step = 0;
        for (int i = 0; i < max; i++) {
            if (i == v1arr.length || i == v2arr.length) {
                step = i;
                break;
            }
            int i1 = getInt(v1arr[i]);
            int i2 = getInt(v2arr[i]);
            if (i1 > i2) {
                return 1;
            } else if (i2 > i1) {
                return -1;
            }
        }
        if (max > v1arr.length) {
            for (int i = step; i < v2arr.length; i++) {
                if (getInt(v2arr[i]) > 0) {
                    return -1;
                }
            }
        } else if (max > v2arr.length) {
            for (int i = step; i < v1arr.length; i++) {
                if (getInt(v1arr[i]) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int getInt(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = r * 10 + s.charAt(i) - '0';
        }
        return r;
    }
}
