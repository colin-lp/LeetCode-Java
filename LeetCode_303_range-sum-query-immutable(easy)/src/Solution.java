public class Solution {
    public static void main(String[] args) {
        NumArray n=new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(n.sumRange(0,2));
    }
}

class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=nums[i]+sum[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}

