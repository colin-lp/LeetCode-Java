import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        List<List<Integer>> ll=s.permute(new int[]{1,2,3});
        System.out.println(ll.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List result=new ArrayList();
        check(result,nums,0);
        return result;
    }

    public void check(List<List<Integer>> result,int[] nums,int index){
        if(index==nums.length){
            result.add(append(nums));
        }
        else{
            for(int i=index;i<nums.length;i++){
                swap(nums,index,i);
                check(result,nums,index+1);
                swap(nums,index,i);
            }
        }
    }

    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }

    public List<Integer> append(int[] nums){
        List<Integer> result=new ArrayList<>();
        for(int i:nums){
            result.add(i);
        }
        return result;
    }
}