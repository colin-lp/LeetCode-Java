import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(x<0){
                x=-x;
            }
            if(nums[x-1]>0){nums[x-1]=-nums[x-1];}
        }
        List<Integer> rst=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                rst.add(i+1);
            }
        }
        return rst;
    }
}
