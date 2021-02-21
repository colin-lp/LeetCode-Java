import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        Solution s = new Solution();
        int rst = s.findShortestSubArray(nums);
        System.out.println(rst);
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            } else {
                map.put(nums[i], new int[]{1,i,i});
            }
        }
        int max = 0, minLen=0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (max < entry.getValue()[0]) {
                max = entry.getValue()[0];
                minLen=entry.getValue()[2]-entry.getValue()[1]+1;
            }else if(max==entry.getValue()[0]){
                int temLen=entry.getValue()[2]-entry.getValue()[1]+1;
                minLen=Math.min(temLen,minLen);
            }
        }
        return minLen;
    }
}