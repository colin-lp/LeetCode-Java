public class Solution {
    public int arrayPairSum(int[] nums) {
        sort(nums,0,nums.length-1);
        int rst=0;
        for(int i=0;i<nums.length;i+=2){
            rst+=nums[i];
        }
        return rst;
    }

    public void sort(int[] nums,int l,int r){
        if(l>=r) return;
        int i= (int) (Math.random() * (r - l + 1)) +l;
        int temp=nums[i];
        nums[i]=nums[l];
        nums[l]=temp;

        int lt=l;
        int gt=r+1;
        i=lt+1;

        while(i<gt){
            if(nums[i]<nums[l]){
                temp=nums[i];
                nums[i]=nums[lt+1];
                nums[lt+1]=temp;
                lt++;
                i++;
            }else if(nums[i]>nums[l]){
                temp=nums[i];
                nums[i]=nums[gt-1];
                nums[gt-1]=temp;
                gt--;
            }else{
                i++;
            }
        }

        temp = nums[l];
        nums[l]=nums[lt];
        nums[lt]=temp;

        sort(nums,l,lt-1);
        sort(nums,gt,r);
    }
}