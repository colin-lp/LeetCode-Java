import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> temp=new ArrayList<>();
    List<List<Integer>> rst=new ArrayList<>();

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.subsets(new int[]{0,1,2}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        find(0,nums);
        return rst;
    }

    private void find(int cur,int[] nums){
        if(cur==nums.length){
            rst.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[cur]);
        find(cur+1,nums);
        temp.remove(temp.size()-1);
        find(cur+1,nums);
    }
}
