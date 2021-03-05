import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1,2,1})));
    }
    LinkedList<Integer> list = new LinkedList<>();

    public int[] nextGreaterElements(int[] nums) {
        int[] rst=new int[nums.length];
        Arrays.fill(rst,-1);
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            //list中小于当前元素值的元素出栈(栈中存元素在数组中的索引)
            while (!list.isEmpty() && (nums[list.peek()] < nums[i % nums.length])) {
                rst[list.pop()]=nums[i%nums.length];
            }
            list.push(i%nums.length);
        }
        return rst;
    }
}
