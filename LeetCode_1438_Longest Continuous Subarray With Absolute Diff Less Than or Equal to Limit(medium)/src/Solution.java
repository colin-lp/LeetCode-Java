import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println(s.longestSubarray(in, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int left = 0, right = 0, max = 0;
        while (right < nums.length) {
            tmap.put(nums[right], tmap.getOrDefault(nums[right], 0) + 1);
            while(tmap.lastKey()-tmap.firstKey()>limit){
                tmap.put(nums[left],tmap.get(nums[left])-1);
                if(tmap.get(nums[left])==0){
                    tmap.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }

    public int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> quMax = new LinkedList<>();
        Deque<Integer> quMin = new LinkedList<>();
        int left = 0, right = 0, max = 0;
        while (right < nums.length) {
            while (!quMax.isEmpty() && quMax.peekLast() < nums[right]) {
                quMax.pollLast();
            }
            while (!quMin.isEmpty() && quMin.peekLast() > nums[right]) {
                quMin.pollLast();
            }
            quMax.offerLast(nums[right]);
            quMin.offerLast(nums[right]);
            while(!quMax.isEmpty() && !quMin.isEmpty() && quMax.peekFirst()-quMin.peekFirst()>limit){
                if(nums[left]==quMax.peekFirst()){
                    quMax.pollFirst();
                }
                if(nums[left]==quMin.peekFirst()){
                    quMin.pollFirst();
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
